package com.spring.security.SpringSecurityDemo.service;

import com.spring.security.SpringSecurityDemo.dto.LoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class JwtAuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtEncoder jwtEncoder;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expire}")
    private Long expiry;

    public String loginUser(LoginRequestDto loginRequestDto){
        Authentication authenticationReq =
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()
                );
        Authentication authenticationResp =
                authenticationManager.authenticate(authenticationReq);
        return generateToke(authenticationResp);
    }

    public String generateToke(Authentication authentication){
        List<String> authorities =
                authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .subject(authentication.getName())
                .issuer(issuer)
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(expiry))
                .claim("authorities", authorities)
                .build();
        Jwt jwt = jwtEncoder.encode(JwtEncoderParameters.from(claimsSet));
        return jwt.getTokenValue();
    }
}
