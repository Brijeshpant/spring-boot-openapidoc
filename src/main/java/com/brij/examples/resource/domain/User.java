package com.brij.examples.resource.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class User {
    @Schema(example = "1234")
    private Long userId;
    @Schema(example = "brij")
    private String firstName;
    @Schema(example = "c")
    private String middleName;
    @Schema(example = "pant")
    private String lastName;
    @Schema(example = "brij@gmail.com")
    private String email;
}
