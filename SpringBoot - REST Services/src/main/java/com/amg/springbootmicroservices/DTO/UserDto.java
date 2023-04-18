package com.amg.springbootmicroservices.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto Model Information"
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    //User first name should not be null or empty
    @Schema(
            description = "User First Name"
    )
    @NotEmpty(message = "User first name should not be null or empty")

    private String firstName;
    @Schema(
            description = "User Last Name"
    )

    //User last name should not be null or empty
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;
    @Schema(
            description = "User Email Address"
    )
    //User email should not be null or empty
    //Email address should be a valid email
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email;
}
