package com.desafiotrivia.Dto;

import com.desafiotrivia.Enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class TicketResponse {

    private UUID ticketId;
    private TicketStatus status;
    private String message;
}
