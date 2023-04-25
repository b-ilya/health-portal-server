package b.illia.healthportal.server.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "auth_tokens")
@NoArgsConstructor
@Getter
@Setter
public class AuthToken {
    @Id
    @Column(
            name = "token",
            updatable = false,
            nullable = false
    )
    @GeneratedValue
    private UUID token;

    @Column(
            name = "issued",
            updatable = false,
            nullable = false
    )
    @CreationTimestamp
    private Instant issued;

    @OneToOne()
    @JoinColumn(
            name = "user_id",
            unique = true,
            updatable = false
    )
    private User user;
}
