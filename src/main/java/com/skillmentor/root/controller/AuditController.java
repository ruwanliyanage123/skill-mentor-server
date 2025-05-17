package com.skillmentor.root.controller;

import com.skillmentor.root.common.Constants;
import com.skillmentor.root.dto.AuditDTO;
import com.skillmentor.root.dto.PaymentDTO;
import com.skillmentor.root.service.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
@Tag(name = "Audit & Mentor Payments", description = "Endpoints for viewing audit logs and mentor payment reports")
public class AuditController {

    @Autowired
    private SessionService sessionService;

    @Operation(
            summary = "Get all audit logs",
            description = "Retrieves all session-based audit trail entries"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success: Audit logs retrieved"),
            @ApiResponse(responseCode = "301", description = "Resource moved permanently"),
            @ApiResponse(responseCode = "302", description = "Resource temporarily moved"),
            @ApiResponse(responseCode = "400", description = "Bad request due to invalid parameters"),
            @ApiResponse(responseCode = "401", description = "Unauthorized: Authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden: Insufficient privileges"),
            @ApiResponse(responseCode = "404", description = "Not Found: No audit logs available"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "503", description = "Service unavailable")
    })
    @GetMapping(value = "/audit", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<List<AuditDTO>> getAllAudits() {
        final List<AuditDTO> auditDTOS = sessionService.getAllAudits();
        return new ResponseEntity<>(auditDTOS, HttpStatus.OK);
    }

    @Operation(
            summary = "Get mentor payments",
            description = "Returns a list of mentor payments filtered optionally by start and end date"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success: Payments retrieved"),
            @ApiResponse(responseCode = "301", description = "Resource moved permanently"),
            @ApiResponse(responseCode = "302", description = "Resource temporarily moved"),
            @ApiResponse(responseCode = "400", description = "Bad request: Invalid date format or parameters"),
            @ApiResponse(responseCode = "401", description = "Unauthorized: Authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden: Access denied"),
            @ApiResponse(responseCode = "404", description = "Not Found: No payment records available"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "503", description = "Service unavailable")
    })
    @GetMapping(value = "/mentor-payments", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<List<PaymentDTO>> findMentorPayments(
            @Parameter(description = "Start date in yyyy-MM-dd format", required = false)
            @RequestParam(name = "startDate", required = false) String startDate,
            @Parameter(description = "End date in yyyy-MM-dd format", required = false)
            @RequestParam(name = "endDate", required = false) String endDate
    ) {
        final List<PaymentDTO> auditDTOS = sessionService.findMentorPayments(startDate, endDate);
        return new ResponseEntity<>(auditDTOS, HttpStatus.OK);
    }
}
