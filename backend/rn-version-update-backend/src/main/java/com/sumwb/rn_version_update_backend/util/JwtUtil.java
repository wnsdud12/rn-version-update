package com.sumwb.rn_version_update_backend.util;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private String secretKey;

    private long expiration;

    public String generateToken(String id) {
        return "";
    }
}
