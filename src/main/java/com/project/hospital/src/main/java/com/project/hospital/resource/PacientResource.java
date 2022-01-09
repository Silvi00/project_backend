package com.project.hospital.resource;

import com.project.hospital.pacient.Pacient;
import com.project.hospital.repo.PacientRepo;
import com.project.hospital.service.implementation.PacientServiceImpl;
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
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/pacient")
@RequiredArgsConstructor
public class PacientResource {

    private final PacientServiceImpl pacientService;
    @Autowired
    PacientRepo pacientRepo;

    @GetMapping("/list")
    public ResponseEntity<Response> getPacienti() throws InterruptedException{
//        TimeUnit.SECONDS.sleep(3); // timpul in care sa apara datele pe ecran
        System.out.println("sunt in save user");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("pacient", pacientService.list(30)))
                        .message("Patients retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Pacient> savePacient(@RequestBody @Valid Pacient pacient) {
        try{

            Pacient pacientNou = pacientRepo
                    .save(new Pacient(pacient.getCNP(), pacient.getNume(), pacient.getPrenume(), pacient.getDataNasterii(), pacient.getSex(), pacient.getStareCivila(),
                            pacient.getNrTelefon(), pacient.getAdresa(), pacient.getOras(), pacient.getJudet(), pacient.getTara(),
                            pacient.getAntecedente(), pacient.getPersoanaContact(), pacient.getTelefonContact()));
            return new ResponseEntity<>(pacientNou, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPacient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("pacient", pacientService.get(id)))
                        .message("Patient retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
