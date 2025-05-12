package com.skillmentor.root.controller;

import com.skillmentor.root.dto.AuditDTO;
import com.skillmentor.root.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/audit")
public class AuditController {
    @Autowired
    private SessionService sessionService;

    @GetMapping()
    public ResponseEntity<List<AuditDTO>> getAllAudits(){
        List<AuditDTO> auditDTOS = sessionService.getAllAudits();
        return new ResponseEntity<>(auditDTOS, HttpStatus.OK);
    }
}
