package b.illia.healthportal.server.security;

import b.illia.healthportal.server.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

    private final TokenService service;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        getTokenFrom(request)
                .flatMap(service::getAuthentication)
                .ifPresent(authentication -> {
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                });

        filterChain.doFilter(request, response);
    }

    private Optional<UUID> getTokenFrom(HttpServletRequest request) {
        String tokenHeader = "Authorization";
        String tokenPrefix = "Bearer ";
        return Optional.ofNullable(request.getHeader(tokenHeader))
                .filter(s -> s.startsWith(tokenPrefix))
                .map(s -> s.substring(tokenPrefix.length()))
                .map(UUID::fromString);
    }
}
