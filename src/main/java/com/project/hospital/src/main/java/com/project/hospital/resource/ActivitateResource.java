package com.project.hospital.resource;

import com.project.hospital.activitate.Activitate;
import com.project.hospital.repo.ActivitateRepo;
import com.project.hospital.service.implementation.ActivitateServiceImpl;
import com.project.hospital.user.Response;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.util.Map.of;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/activitate")
@RequiredArgsConstructor
public class ActivitateResource {

    private final ActivitateServiceImpl activitateService;
    @Autowired
    ActivitateRepo activitateRepo;

    @GetMapping("/list")
    public ResponseEntity<Response> getActivities() throws InterruptedException{
        //TimeUnit.SECONDS.sleep(3); // timpul in care sa apara datele pe ecran
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("activitate", activitateService.list(30)))
                        .message("Activities retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Activitate> saveActivitate(@RequestBody @Valid Activitate activitate) {
        try{

            Activitate actvt = activitateRepo
                    .save(new Activitate(activitate.getOra(), activitate.getData(), activitate.getSubiect(), activitate.getDescriere()));
            return new ResponseEntity<>(actvt, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getActivitate(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("activitate", activitateService.get(id)))
                        .message("Activities retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
