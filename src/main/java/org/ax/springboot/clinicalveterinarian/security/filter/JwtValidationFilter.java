package org.ax.springboot.clinicalveterinarian.security.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;

import static org.ax.springboot.clinicalveterinarian.security.TokenJwtConfig.*;

public class JwtValidationFilter extends BasicAuthenticationFilter {

    public JwtValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_AUTHORIZATION);

        if (header == null || !header.startsWith(PREFIX_TOKEN)) {
            chain.doFilter(request, response);
            return;
        }

        String token = header.substring(PREFIX_TOKEN.length());

        try {
            Claims claims = Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload();
        } catch (JwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(e.getMessage());
            return;
        }

    }
}
