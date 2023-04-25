package b.illia.healthportal.server.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "places")
@NoArgsConstructor
@Getter
@Setter
public class Place {

    @Id
    @GeneratedValue
    private UUID id;

    private String city;

    private String state;

    private String country;

    @Column(
            name = "zipcode"
    )
    private String zip;
}
