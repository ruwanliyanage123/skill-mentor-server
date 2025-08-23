package com.skillmentor.root.service.impl;

import com.skillmentor.root.service.ContentService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ContentServiceImpl implements ContentService {
    private final Path uploadLocation = Paths.get("/Users/ruwan/Desktop/spring-boot-sessions/skill-mentor-root/upload");

    @Override
    public String uploadFile(MultipartFile file){
        try {
            if (!Files.exists(uploadLocation)) {
                Files.createDirectories(uploadLocation);
            }
            String fileName = Path.of(file.getOriginalFilename()).getFileName().toString();
            Path targetPath = uploadLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }catch(IOException exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Resource downloadFile(String fileName) {
        try {
            Path filePath = uploadLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("File not found or not readable: " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
