package com.springboot.security.util;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ Create by ostreamBaba on 18-5-27
 * @ 描述
 */

public class passwordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals( charSequence.toString() );
    }
}
