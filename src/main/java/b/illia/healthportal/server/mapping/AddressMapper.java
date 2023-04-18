package b.illia.healthportal.server.mapping;

import b.illia.healthportal.server.api.model.AddressDto;
import b.illia.healthportal.server.data.model.Address;
import b.illia.healthportal.server.data.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    Place toPlaceEntity(AddressDto source);

    @Mapping(target = "place", source = "source")
    @Mapping(target = "addressLine", source = "source.streetAddress")
    Address toEntity(AddressDto source);

    @Mapping(target = "streetAddress", source = "source.addressLine")
    @Mapping(target = "city", source = "source.place.city")
    @Mapping(target = "state", source = "source.place.state")
    @Mapping(target = "country", source = "source.place.country")
    @Mapping(target = "zip", source = "source.place.zip")
    AddressDto toDto(Address source);
}
