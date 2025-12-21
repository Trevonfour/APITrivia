package com.desafiotrivia.Service;
import com.desafiotrivia.Domain.Customer;
import com.desafiotrivia.Domain.Ticket;
import com.desafiotrivia.Dto.TicketPurchaseRequest;
import com.desafiotrivia.Dto.TicketResponse;
import com.desafiotrivia.Dto.TicketValidationRequest;
import com.desafiotrivia.Enums.TicketStatus;
import com.desafiotrivia.Enums.ValidationDirection;
import com.desafiotrivia.Exception.BusinessException;
import com.desafiotrivia.Exception.TicketNotFoundException;
import com.desafiotrivia.Repository.CustomerRepository;
import com.desafiotrivia.Repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService {

    private final TicketRepository ticketRepository;
    private final CustomerRepository customerRepository;

    public TicketResponse purchaseTicket(TicketPurchaseRequest request) {

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setDocument(request.getDocument());
        customerRepository.save(customer);

        Ticket ticket = new Ticket();
        ticket.setCustomer(customer);
        ticket.setStatus(TicketStatus.AVAILABLE);
        ticket.setPurchaseDate(LocalDateTime.now());

        ticketRepository.save(ticket);

        return new TicketResponse(ticket.getId(), ticket.getStatus(), "Bilhete comprado com sucesso");
    }

    public TicketResponse validateTicket(UUID ticketId, TicketValidationRequest request) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException("Bilhete inválido"));

        if (request.getDirection() == ValidationDirection.ENTRY) {
            validateEntry(ticket, request.getStation());
        } else {
            validateExit(ticket, request.getStation());
        }

        return new TicketResponse(ticket.getId(), ticket.getStatus(), "Validação realizada com sucesso");
    }

    private void validateEntry(Ticket ticket, String station) {

        if (ticket.getStatus() != TicketStatus.AVAILABLE) {
            throw new BusinessException("Bilhete não disponível para entrada");
        }

        ticket.setStatus(TicketStatus.IN_USE);
        ticket.setEntryStation(station);
        ticket.setEntryTime(LocalDateTime.now());
    }

    private void validateExit(Ticket ticket, String station) {

        if (ticket.getStatus() != TicketStatus.IN_USE) {
            throw new BusinessException("Bilhete não está em uso para saída");
        }

        ticket.setStatus(TicketStatus.USED);
        ticket.setExitStation(station);
        ticket.setExitTime(LocalDateTime.now());
    }
}
