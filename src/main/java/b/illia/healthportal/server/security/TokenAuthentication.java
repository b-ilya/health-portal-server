package b.illia.healthportal.server.security;

import b.illia.healthportal.server.data.model.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;


public class TokenAuthentication extends AbstractAuthenticationToken {

    private final UserDetails details;
    private final UUID token;

    public static TokenAuthentication of(User user, UUID token) {
        return new TokenAuthentication(token, user, authoritiesOf(user));
    }

    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */
    private TokenAuthentication(UUID token, User user, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.token = token;
        this.details = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPasswordHash(),
                authorities
        );
        setAuthenticated(true);
    }

    private static Collection<GrantedAuthority> authoritiesOf(User user) {
        var authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (user.getSuperuser()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_SUPER"));
        }
        return authorities;
    }

    @Override
    public UUID getCredentials() {
        return token;
    }

    @Override
    public UserDetails getPrincipal() {
        return details;
    }
}
