package com.brij.examples.resource;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationResponse {
    @Schema(example = "User created")
    private String message;
    @Schema(example = "1234")
    private Long userId;
}

