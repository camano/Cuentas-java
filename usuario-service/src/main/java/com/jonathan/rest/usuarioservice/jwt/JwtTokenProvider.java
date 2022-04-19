package com.jonathan.rest.usuarioservice.jwt;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.jonathan.rest.usuarioservice.exception.AuthException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtTokenProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;

    public String generarToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = authentication.getName();
        Date fechaActual = new Date();
        Date fechaExpiracion = new Date(fechaActual.getTime() + jwtExpirationInMs);
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String token = Jwts.builder().setSubject(username).claim("roles", roles).setIssuedAt(new Date())
                .setExpiration(fechaExpiracion).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

        return token;
    }

    public String obtenerUsernameDelJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            logger.error("fail en la firma");
            throw new AuthException(HttpStatus.BAD_REQUEST, "Firma JWT no valida");
        } catch (MalformedJwtException ex) {
            logger.error("token mal formado");
            throw new AuthException(HttpStatus.BAD_REQUEST, "Token JWT no valida");
        } catch (ExpiredJwtException ex) {
            logger.error("token expirado");
            throw new AuthException(HttpStatus.BAD_REQUEST, "Token JWT caducado");
        } catch (UnsupportedJwtException ex) {
            logger.error("token no soportado");
            throw new AuthException(HttpStatus.BAD_REQUEST, "Token JWT no compatible");
        } catch (IllegalArgumentException ex) {
            logger.error("token vacío");
            throw new AuthException(HttpStatus.BAD_REQUEST, "La cadena claims JWT esta vacia");
        }
    }
}
