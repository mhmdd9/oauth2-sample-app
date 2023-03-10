package com.github.mhmdd9.oauth2sample.config;

import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@NoArgsConstructor
public class JwtGrantedAuthorityConverter implements Converter<Jwt, Collection<GrantedAuthority>> {


    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        return SecurityUtils.extractAuthorityFromClaims(jwt.getClaims());
    }
}
