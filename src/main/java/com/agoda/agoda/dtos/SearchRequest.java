package com.agoda.agoda.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SearchRequest {
    @NotBlank
    private String origin;
    @NotBlank
    private String destination;
}