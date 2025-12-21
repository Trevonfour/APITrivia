package com.desafiotrivia.Domain;
import com.desafiotrivia.Enums.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    private LocalDateTime purchaseDate;

    private String entryStation;
    private LocalDateTime entryTime;

    private String exitStation;
    private LocalDateTime exitTime;
}
