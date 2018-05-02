package mapstruct.test;
import java.util.UUID;

public class SomeType
{
    private final String name;
    private final UUID id;

    public SomeType(final String name, final UUID id)
    {
        this.name = name;
        this.id = id;
    }

    public final String getName()
    {
        return name;
    }

    public final UUID getId()
    {
        return id;
    }

}
