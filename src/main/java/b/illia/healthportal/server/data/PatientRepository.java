package b.illia.healthportal.server.data;

import b.illia.healthportal.server.data.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
