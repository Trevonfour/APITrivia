package com.desafiotrivia.Dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketPurchaseRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String document;
}
