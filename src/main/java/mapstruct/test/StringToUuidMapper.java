package mapstruct.test;
import java.util.UUID;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class StringToUuidMapper
{

    public UUID uuidFromString(final String uuidString)
    {
        return UUID.fromString(uuidString);
    }

    public String uuidToString(final UUID uuid)
    {
        return uuid.toString();
    }

}
