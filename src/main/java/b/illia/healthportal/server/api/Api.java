package b.illia.healthportal.server.api;

import org.springframework.http.MediaType;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

public interface Api {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    default void setExampleResponse(String mime, String contentString) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(mime))) {
                    ApiUtil.setExampleResponse(request, mime, contentString);
                    break;
                }
            }
        });

    }
}
