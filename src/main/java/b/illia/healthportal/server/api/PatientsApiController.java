package b.illia.healthportal.server.api;

import b.illia.healthportal.server.api.model.AddressDto;
import b.illia.healthportal.server.api.model.PatientsListDto;
import b.illia.healthportal.server.api.model.SavedPatientDto;
import b.illia.healthportal.server.api.model.SexEnum;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PatientsApiController implements PatientsApi {

    private final NativeWebRequest request;

    @Autowired
    public PatientsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<PatientsListDto> listPatients(Integer offset, Integer limit, String q) {
        return PatientsApi.super.listPatients(offset, limit, q);
    }

    @Override
    public ResponseEntity<SavedPatientDto> getPatient(Long patientId) {
        var patient = new SavedPatientDto(patientId, "John", "Doe", SexEnum.MALE,
                LocalDate.of(1970, Month.JANUARY, 1),
                new AddressDto("3, Some str.", "New-York", "USA"));
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
}
