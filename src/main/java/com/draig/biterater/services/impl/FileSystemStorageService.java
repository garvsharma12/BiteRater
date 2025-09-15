package com.draig.biterater.services.impl;

import com.draig.biterater.exceptions.StorageException;
import com.draig.biterater.services.StorageService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@Slf4j
public class FileSystemStorageService implements StorageService {

    @Value("${app.storage.location:uploads}")
    private String storageLocation;

    private Path rootLocation;

    @PostConstruct
    public void init() {
        rootLocation = Paths.get(storageLocation);
        try{
            Files.createDirectories(rootLocation);
        }
        catch(Exception e){
            throw new StorageException("Could not create the directory where the uploaded files will be stored.", e);
        }
    }
    @Override
    public String store(MultipartFile file, String filename) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
            String finalFilename = filename + "." + extension;

            Path destinationFile = rootLocation.resolve(Paths.get(finalFilename)).normalize().toAbsolutePath();

            if (!destinationFile.getParent().equals(rootLocation.toAbsolutePath())) {
                throw new StorageException("Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            return finalFilename;
        }
        catch(Exception e){
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    public Optional<Resource> loadAsResource(String filename){
        try {
            Path file = rootLocation.resolve(filename);

            UrlResource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return Optional.of(resource);
            }
            else{
                return Optional.empty();
            }
        }
        catch(MalformedURLException e){
            log.warn("Failed to load file {}", filename, e);
            return Optional.empty();
        }
    }
}
