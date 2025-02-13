package com.operadores.operators.controller;

import com.operadores.operators.dto.create.ViajeCreate;
import com.operadores.operators.dto.request.ImageRequest;
import com.operadores.operators.service.ViajeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/api/viaje")
@RequiredArgsConstructor
public class ViajeController {

    private static final Logger LOG = LoggerFactory.getLogger(ViajeController.class);
    private final ViajeService service;

    @GetMapping
    public ResponseEntity<?> getViaje(){
        LOG.info("GET VIAJE");

        return ResponseEntity.ok(service.getActiveViaje());
    }

    @PostMapping
    public ResponseEntity<?> createViaje(@RequestBody ViajeCreate viaje){
        LOG.info("CREATED TRAVEL {}", viaje);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(viaje));
    }

    @PostMapping("/upload")
    public ResponseEntity<ImageRequest> uploadImage(@RequestParam("file") MultipartFile file) {
        LOG.info("Received image upload request: {}", file.getOriginalFilename());

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        ImageRequest imageRequest = service.saveImage(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(imageRequest);
    }
}
