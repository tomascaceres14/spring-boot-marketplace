package com.tomasdev.akhanta.security.jwt;

import com.tomasdev.akhanta.exceptions.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerMapping;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final HandlerExceptionResolver resolver;
    public JwtAuthFilter(JwtService jwtService, @Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        this.jwtService = jwtService;
        this.resolver = resolver;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        // No filtrar si la ruta no existe
        return request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE) == null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException, UnauthorizedException {
        Authentication auth;
        String jwt = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (jwt == null) {
            filterChain.doFilter(request, response);
            return;
        }

        if (!jwt.startsWith("Bearer ")) {
            resolver.resolveException(request, response, null, new UnauthorizedException("Formato de token inválido."));
            return;
        }

        jwt = jwt.substring(7);

        try {
            auth = jwtService.authorizeToken(jwt);
        }catch (Exception e) {
            resolver.resolveException(request, response, null, new UnauthorizedException(e.getMessage()));
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }
}