package com.brij.examples.resource;

import com.brij.examples.resource.domain.ApiError;
import com.brij.examples.resource.domain.CreateUserRequest;
import com.brij.examples.resource.domain.User;
import com.brij.examples.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/api/users")
    @Operation(summary = "API for user creation", description = "This API creates user. If email already exists, user can not be created.", tags = {"user creation", "user access"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Response for successful user creation",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserCreationResponse.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))
                    })
    }
    )
    UserCreationResponse createUser(@Valid @RequestBody CreateUserRequest user) {
        return userService.createUser(user);
    }

    @Operation(summary = "API to search user", description = "This API finds user based on the userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Response for successful user search",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))
                    })
    }
    )
    @GetMapping("/api/users/{userId}")
    User getUser(@Valid @PathVariable("userId") @Parameter(example = "1234") Long userId) {
        return userService.getUser(userId);

    }
}
