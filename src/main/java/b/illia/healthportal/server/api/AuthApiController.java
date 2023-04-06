package b.illia.healthportal.server.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${openapi.bIlliaHealthPortalOpenAPI30.base-path:}")
public class AuthApiController implements AuthApi {

}
