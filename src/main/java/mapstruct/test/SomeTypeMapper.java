package mapstruct.test;

import java.util.UUID;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {StringToUuidMapper.class})
public interface SomeTypeMapper
{
    default SomeType toImmutableType(final SomeTypeDto dto)
    {
        // FIXME: How to use the supplied StringToUuidMapper here?
        return new SomeType(dto.getName(), UUID.fromString(dto.getId()));
    }

    SomeTypeDto toDto(SomeType model);
}
