package b.illia.healthportal.server.mapping;

import b.illia.healthportal.server.api.model.AddressDto;
import b.illia.healthportal.server.api.model.PatientDto;
import b.illia.healthportal.server.api.model.PatientsListDto;
import b.illia.healthportal.server.api.model.SavedPatientDto;
import b.illia.healthportal.server.data.model.Address;
import b.illia.healthportal.server.data.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class PatientMapper {
    @Autowired
    protected AddressMapper addressMapper;

    protected Address toAddressEntity(AddressDto source) {
        return addressMapper.toEntity(source);
    }

    protected AddressDto toAddressDto(Address source) {
        return addressMapper.toDto(source);
    }

    @Mapping(target = "totalCount", source = "total")
    @Mapping(target = "count", source = "count")
    @Mapping(target = "offset", source = "offset")
    @Mapping(target = "hasMore", source = "hasMore")
    @Mapping(target = "patients", source = "patients")
    public abstract PatientsListDto toListDto(
            Integer total,
            Integer count,
            Integer offset,
            Boolean hasMore,
            List<Patient> patients);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", source = "source.address")
    public abstract Patient toEntity(PatientDto source);

    public abstract SavedPatientDto toDto(Patient source);
}
