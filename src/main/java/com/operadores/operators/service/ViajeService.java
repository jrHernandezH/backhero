package com.operadores.operators.service;

import com.operadores.operators.dto.create.ViajeCreate;
import com.operadores.operators.dto.request.ImageRequest;
import com.operadores.operators.enums.EstadoEnum;
import com.operadores.operators.model.Viaje;
import com.operadores.operators.repository.ViajeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ViajeService {

    private final ViajeRepository viajeRepository;
    private static final Logger LOG = LoggerFactory.getLogger(ViajeService.class);
    private static final String IMAGE_FOLDER = "src/main/resources/static/images/";


    public ViajeCreate create(ViajeCreate viajeCreate) {
        LOG.info("Creating a new Viaje");

        //pass to entity with beanutils
        Viaje viaje = new Viaje();
        BeanUtils.copyProperties(viajeCreate, viaje);


        viaje.setEstado(EstadoEnum.ACTIVO);
        viajeRepository.save(viaje);

        return viajeCreate;
    }

    // get viaje active
    public Viaje getActiveViaje() {
        LOG.info("Getting active Viaje");

        Optional<Viaje> optionalViaje = viajeRepository.findByEstado(EstadoEnum.ACTIVO);

        if (optionalViaje.isPresent()) {
            return optionalViaje.get();
        } else {
            return null;
        }
    }

    //save img and return path
    public ImageRequest saveImage(MultipartFile file) {
        LOG.info("Saving image...");

        // Validar si el archivo no es nulo o vacío
        if (file == null) {
            LOG.warn("No file received in the request. File is null.");
            throw new RuntimeException("No file received in the request.");
        }

        if (file.isEmpty()) {
            LOG.warn("File is empty. Original filename: {}", file.getOriginalFilename());
            throw new RuntimeException("Uploaded file is empty.");
        }

        LOG.info("File received: name={}, size={}, contentType={}",
                file.getOriginalFilename(), file.getSize(), file.getContentType());

        try {
            // Crear directorio si no existe
            Path folderPath = Paths.get(IMAGE_FOLDER);
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
                LOG.info("Directory created at {}", folderPath.toAbsolutePath());
            }

            // Guardar archivo
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = folderPath.resolve(fileName);

            LOG.info("Saving file to path: {}", filePath.toAbsolutePath());
            Files.copy(file.getInputStream(), filePath);

            LOG.info("Image successfully saved at {}", filePath.toAbsolutePath());

            // Crear y devolver ImageRequest
            ImageRequest imageRequest = new ImageRequest();
            imageRequest.setImageName(fileName);
            imageRequest.setImageType(file.getContentType());
            imageRequest.setImgPath("/images/" + fileName); // Ruta relativa para acceder desde el cliente

            LOG.info("ImageRequest created: {}", imageRequest);
            return imageRequest;

        } catch (IOException e) {
            LOG.error("Error saving image", e);
            throw new RuntimeException("Error saving image: " + e.getMessage());
        }
    }


}
