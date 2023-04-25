package b.illia.healthportal.server.data;

import b.illia.healthportal.server.data.model.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, UUID> {
}
