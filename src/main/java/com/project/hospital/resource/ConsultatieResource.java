package com.project.hospital.resource;

import com.project.hospital.consultatie.Consultatie;
import com.project.hospital.pacient.Pacient;
import com.project.hospital.repo.ConsultatieRepo;
import com.project.hospital.repo.PacientRepo;
import com.project.hospital.service.implementation.ConsultatieServiceImpl;
import com.project.hospital.service.implementation.PacientServiceImpl;
import com.project.hospital.user.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/consultatie")
@RequiredArgsConstructor
public class ConsultatieResource {
    private final ConsultatieServiceImpl consultatieService;
    @Autowired
    ConsultatieRepo consultatieRepo;

    @GetMapping("/list")
    public ResponseEntity<Response> getConsultatii() throws InterruptedException{
//        TimeUnit.SECONDS.sleep(3); // timpul in care sa apara datele pe ecran
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("consultatie", consultatieService.list(30)))
                        .message("Consultatii retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Consultatie> saveConsultatie(@RequestBody @Valid Consultatie consultatie) {
        try{

            Consultatie consultatieNou = consultatieRepo
                    .save(new Consultatie(consultatie.getCNP(),consultatie.getNume(),consultatie.getPrenume(),
                            consultatie.getDataConsultatie(),consultatie.getSimptome(),consultatie.getDiagnostic(),
                            consultatie.getPrescriptie()));
            return new ResponseEntity<>(consultatieNou, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getConsultatie(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("consultatie", consultatieService.get(id)))
                        .message("Consultatie retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
