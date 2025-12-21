package com.desafiotrivia.Controller;

import com.desafiotrivia.Dto.TicketPurchaseRequest;
import com.desafiotrivia.Dto.TicketResponse;
import com.desafiotrivia.Dto.TicketValidationRequest;
import com.desafiotrivia.Service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketResponse> purchase(@Valid @RequestBody TicketPurchaseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ticketService.purchaseTicket(request));
    }

    @PostMapping("/{ticketId}/validate")
    public ResponseEntity<TicketResponse> validate(
            @PathVariable UUID ticketId,
            @Valid @RequestBody TicketValidationRequest request) {

        return ResponseEntity.ok(ticketService.validateTicket(ticketId, request));
    }
}
