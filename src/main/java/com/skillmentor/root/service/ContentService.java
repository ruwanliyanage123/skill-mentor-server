package com.skillmentor.root.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ContentService {

    public abstract String uploadFile(MultipartFile file);

    public abstract Resource downloadFile(String fileName);
}
