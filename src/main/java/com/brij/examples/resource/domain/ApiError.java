package com.brij.examples.resource.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class ApiError {
    @Schema(example = "Error message")
    private String message;
    @Schema(example = "[\"firstname\",\"email\"]")
    private List<String> invalidFields;

}
