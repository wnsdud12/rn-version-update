package com.sumwb.rn_version_update_backend.dto.signup;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
    private String email;
    private String password;
}
