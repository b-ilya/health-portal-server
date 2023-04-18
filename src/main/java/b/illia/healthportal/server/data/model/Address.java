package b.illia.healthportal.server.data.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Column(name = "address")
    private String addressLine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;
}
