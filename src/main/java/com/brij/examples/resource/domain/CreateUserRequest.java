package com.brij.examples.resource.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@ToString
@Getter
@Setter
public class CreateUserRequest {
    @NotNull
    @Schema(example = "brij")
    private String firstName;
    @Schema(example = "c")
    private String middleName;
    @NotNull
    @NotNull
    @Schema(example = "pant")
    private String lastName;
    @NotNull
    @Schema(example = "brij@gmail.com")
    private String email;
}
