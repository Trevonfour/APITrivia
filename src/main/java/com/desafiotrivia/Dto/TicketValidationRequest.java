package com.desafiotrivia.Dto;

import jakarta.validation.constraints.NotBlank;
import com.desafiotrivia.Enums.ValidationDirection;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class TicketValidationRequest {

    @NotNull
    private ValidationDirection direction;

    @NotBlank
    private String station;
}
