package com.example.social_network.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "firstName is Mandatory")
    @NotBlank(message = "firstName is Mandatory")
    private  String firstName;
    @NotEmpty(message = "lastName is Mandatory")
    @NotBlank(message = "lastName is Mandatory")
    private  String lastName;
    @Email(message = "use the correct email")
    @NotEmpty(message = "email is Mandatory")
    @NotBlank(message = "email is Mandatory")
    private String email;
    @Size(min = 8, message = "Password should be 8 Characters long minimum")
    private String password;
}
