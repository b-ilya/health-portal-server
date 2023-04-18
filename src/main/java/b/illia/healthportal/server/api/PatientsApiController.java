package b.illia.healthportal.server.api;

import b.illia.healthportal.server.api.model.AddressDto;
import b.illia.healthportal.server.api.model.PatientDto;
import b.illia.healthportal.server.api.model.PatientsListDto;
import b.illia.healthportal.server.api.model.SavedPatientDto;
import b.illia.healthportal.server.api.model.SexEnum;
import b.illia.healthportal.server.data.UserRepository;
import b.illia.healthportal.server.data.model.Patient;
import b.illia.healthportal.server.data.model.PatientRepository;
import b.illia.healthportal.server.mapping.PatientMapper;
import b.illia.healthportal.server.mapping.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.bIlliaHealthPortalOpenAPI30.base-path:}")
@AllArgsConstructor
public class PatientsApiController implements PatientsApi {

    private final NativeWebRequest request;
    private final PatientRepository repository;
    private final PatientMapper mapper;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<PatientsListDto> listPatients(Integer offset, Integer limit, String q) {
        var pagable = limit == null ? Pageable.unpaged() : Pageable.ofSize(limit).withPage(offset);
        var page = repository.findAll(pagable);
        return ResponseEntity.ok(
                mapper.toListDto(
                        (int) page.getTotalElements(),
                        page.getNumberOfElements(),
                        page.getNumber(),
                        page.hasNext(),
                        page.getContent()
                )
        );
    }

    @Override
    public ResponseEntity<SavedPatientDto> getPatient(String patientId) {
        return repository.findById(patientId)
                .map(mapper::toDto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<SavedPatientDto> addPatient(PatientDto patient) {
        // check no problems with patient
        Patient storedPatient = repository.save(mapper.toEntity(patient));
        return ResponseEntity.ok(mapper.toDto(storedPatient));
    }


}
