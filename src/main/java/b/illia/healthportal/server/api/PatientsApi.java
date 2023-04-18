package b.illia.healthportal.server.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import b.illia.healthportal.server.api.model.PatientDto;
import b.illia.healthportal.server.api.model.PatientsListDto;
import b.illia.healthportal.server.api.model.SavedPatientDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Validated
@Tag(name = "patients", description = "the patients API")
public interface PatientsApi extends Api {

    /**
     * POST /patients : Add new patient
     *
     * @param patient  (required)
     * @return A patient successfully added (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     */
    @Operation(
        operationId = "addPatient",
        summary = "Add new patient",
        tags = { "patients" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A patient successfully added", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SavedPatientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
        },
        security = {
            @SecurityRequirement(name = "health_portal_auth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/patients",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<SavedPatientDto> addPatient(
        @Parameter(name = "Patient", description = "", required = true) @Valid @RequestBody PatientDto patient
    ) {
        setExampleResponse("application/json", "null");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /patients/{patientId} : Delete a patient
     *
     * @param patientId  (required)
     * @return Operation was successful (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Requested resource is not found or unaccessible (status code 404)
     */
    @Operation(
        operationId = "deletePatient",
        summary = "Delete a patient",
        tags = { "patients" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Operation was successful"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Requested resource is not found or unaccessible")
        },
        security = {
            @SecurityRequirement(name = "health_portal_auth")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/patients/{patientId}"
    )
    default ResponseEntity<Void> deletePatient(
        @Parameter(name = "patientId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("patientId") String patientId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /patients/{patientId} : Get specific patient
     *
     * @param patientId  (required)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Requested resource is not found or unaccessible (status code 404)
     */
    @Operation(
        operationId = "getPatient",
        summary = "Get specific patient",
        tags = { "patients" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SavedPatientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Requested resource is not found or unaccessible")
        },
        security = {
            @SecurityRequirement(name = "health_portal_auth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/patients/{patientId}",
        produces = { "application/json" }
    )
    default ResponseEntity<SavedPatientDto> getPatient(
        @Parameter(name = "patientId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("patientId") String patientId
    ) {
        setExampleResponse("application/json", "null");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /patients : Get list of patients
     *
     * @param offset  (optional)
     * @param limit  (optional)
     * @param q  (optional)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     */
    @Operation(
        operationId = "listPatients",
        summary = "Get list of patients",
        tags = { "patients" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PatientsListDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
        },
        security = {
            @SecurityRequirement(name = "health_portal_auth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/patients",
        produces = { "application/json" }
    )
    default ResponseEntity<PatientsListDto> listPatients(
        @Parameter(name = "offset", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "offset", required = false) Integer offset,
        @Parameter(name = "limit", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit,
        @Parameter(name = "q", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "q", required = false) String q
    ) {
        setExampleResponse("application/json", "null");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }




    /**
     * PUT /patients/{patientId} : Save changes to a Patient
     *
     * @param patientId  (required)
     * @param patient  (optional)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Requested resource is not found or unaccessible (status code 404)
     */
    @Operation(
        operationId = "updatePatient",
        summary = "Save changes to a Patient",
        tags = { "patients" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SavedPatientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Requested resource is not found or unaccessible")
        },
        security = {
            @SecurityRequirement(name = "health_portal_auth")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/patients/{patientId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<SavedPatientDto> updatePatient(
        @Parameter(name = "patientId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("patientId") String patientId,
        @Parameter(name = "Patient", description = "") @Valid @RequestBody(required = false) PatientDto patient
    ) {
        setExampleResponse("application/json", "null");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
