package b.illia.healthportal.server.api;

import b.illia.healthportal.server.api.model.PatientRecordDto;
import b.illia.healthportal.server.api.model.PatientRecordsListDto;
import b.illia.healthportal.server.api.model.SavedPatientRecordDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@Tag(name = "patientRecords", description = "the patient records API")
public interface PatientRecordsApi extends Api {

    /**
     * POST /patients/{patientId}/records : Add a record (comment) to a patient
     *
     * @param patientId  (required)
     * @param patientRecord  (required)
     * @return A patient record (comment) successfully added (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Requested resource is not found or unaccessible (status code 404)
     */
    @Operation(
            operationId = "addRecord",
            summary = "Add a record (comment) to a patient",
            tags = { "patientRecords" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "A patient record (comment) successfully added", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = SavedPatientRecordDto.class))
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
            method = RequestMethod.POST,
            value = "/patients/{patientId}/records",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<SavedPatientRecordDto> addRecord(
            @Parameter(name = "patientId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("patientId") String patientId,
            @Parameter(name = "PatientRecord", description = "", required = true) @Valid @RequestBody PatientRecordDto patientRecord
    ) {
        setExampleResponse("application/json", "null");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /patients/{patientId}/records/{recordId} : Delete a patient&#39;s record (comment)
     *
     * @param patientId  (required)
     * @param recordId  (required)
     * @return Operation was successful (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Requested resource is not found or unaccessible (status code 404)
     */
    @Operation(
            operationId = "deleteRecord",
            summary = "Delete a patient's record (comment)",
            tags = { "patientRecords" },
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
            value = "/patients/{patientId}/records/{recordId}"
    )
    default ResponseEntity<Void> deleteRecord(
            @Parameter(name = "patientId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("patientId") String patientId,
            @Parameter(name = "recordId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("recordId") String recordId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /patients/{patientId}/records : list all of patient records (comments)
     *
     * @param patientId  (required)
     * @param offset  (optional)
     * @param limit  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "listRecords",
            summary = "list all of patient records (comments)",
            tags = { "patientRecords" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PatientRecordsListDto.class))
                    })
            },
            security = {
                    @SecurityRequirement(name = "health_portal_auth")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/patients/{patientId}/records",
            produces = { "application/json" }
    )
    default ResponseEntity<PatientRecordsListDto> listRecords(
            @Parameter(name = "patientId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("patientId") Long patientId,
            @Parameter(name = "offset", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "offset", required = false) Integer offset,
            @Parameter(name = "limit", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit
    ) {
        setExampleResponse("application/json", "null");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /patients/{patientId}/records/{recordId} : Update patient&#39;s record (comment)
     *
     * @param patientId  (required)
     * @param recordId  (required)
     * @return An updated patient record (comment) saved (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Requested resource is not found or unaccessible (status code 404)
     */
    @Operation(
            operationId = "updateRecord",
            summary = "Update patient's record (comment)",
            tags = { "patientRecords" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "An updated patient record (comment) saved", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = SavedPatientRecordDto.class))
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
            value = "/patients/{patientId}/records/{recordId}",
            produces = { "application/json" }
    )
    default ResponseEntity<SavedPatientRecordDto> updateRecord(
            @Parameter(name = "patientId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("patientId") Long patientId,
            @Parameter(name = "recordId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("recordId") Long recordId
    ) {
        setExampleResponse("application/json", "null");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
