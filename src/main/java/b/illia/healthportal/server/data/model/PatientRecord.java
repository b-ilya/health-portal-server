package b.illia.healthportal.server.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_records")
public class PatientRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
}
