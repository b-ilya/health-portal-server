package b.illia.healthportal.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Controller
@RequestMapping("${openapi.bIlliaHealthPortalOpenAPI30.base-path:}")
public class PatientRecordsApiController implements PatientRecordsApi {

    private final NativeWebRequest request;

    @Autowired
    public PatientRecordsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
