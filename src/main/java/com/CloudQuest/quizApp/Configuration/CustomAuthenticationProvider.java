package com.CloudQuest.quizApp.Configuration;

import com.CloudQuest.quizApp.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final JwtUtil jwtUtil;

    public CustomAuthenticationProvider(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String token = (String) authentication.getPrincipal();

        String username = jwtUtil.extractClaims(token).getSubject();

        if (jwtUtil.validateToken(token, username)) {
            UserDetails userDetails = User.builder()
                    .username(username)
                    .password("")
                    .authorities("ROLE_USER")
                    .build();

            return new UsernamePasswordAuthenticationToken(userDetails, token, userDetails.getAuthorities());
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
