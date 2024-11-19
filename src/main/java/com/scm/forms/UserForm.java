package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(message = "Minimum 3 characters required",min=3)
    private String name;
    @NotBlank(message = "Invalid Email Address")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(message = "Minimum 6 characters required",min=6)
    private String password;
    @NotBlank(message = "About is required")
    private String about;
    @Size(message = "Invalid Phone Number only BD number",min=11,max=11)
    private String phoneNumber;
}
