package com.ditjhaba.spring.spike.DTO;

import com.ditjhaba.spring.spike.Enum.Role;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class UserDTO {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordRepeated;

    @NotNull
    private Role role = Role.USER;

    public UserDTO(String email, String password, String passwordRepeated) {
        this.email = email;
        this.password = password;
        this.passwordRepeated = passwordRepeated;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public Role getRole() {
        return role;
    }
}
