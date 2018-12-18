package com.app.exes.entities.request;

import com.app.exes.util.Cosntants;
import com.app.exes.util.NotHtml;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class AutenticateUserRequest {


    @NotNull(message = Cosntants.DATO_OBLIGATORIO)
    @NotHtml
    @Valid
    String email;

    @NotNull(message = Cosntants.DATO_OBLIGATORIO)
    @NotHtml
    @Valid
    String password;

}
