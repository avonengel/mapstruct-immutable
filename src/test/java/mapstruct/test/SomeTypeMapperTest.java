package mapstruct.test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mapstruct.test.SomeType;
import mapstruct.test.SomeTypeDto;
import mapstruct.test.SomeTypeMapper;
import mapstruct.test.SpringConfiguration;

@SpringBootTest(classes = SpringConfiguration.class)
@RunWith(SpringRunner.class)
public class SomeTypeMapperTest
{
    @Autowired
    private SomeTypeMapper underTest;

    @Test
    public void testMappingToDto() throws Exception
    {
        // Arrange
        final SomeType someType = new SomeType("some name", UUID.randomUUID());

        // Act
        final SomeTypeDto result = underTest.toDto(someType);

        // Assert
        assertThat(result.getName(), equalTo(someType.getName()));
        assertThat(result.getId(), equalTo(someType.getId().toString()));
    }

    @Test
    public void testMappingToModel() throws Exception
    {
        // Arrange
        final UUID inputUuid = UUID.randomUUID();
        final SomeTypeDto someTypeDto = new SomeTypeDto();
        someTypeDto.setName("some name");
        someTypeDto.setId(inputUuid.toString());

        // Act
        final SomeType result = underTest.toImmutableType(someTypeDto);

        // Assert
        assertThat(result.getName(), equalTo(someTypeDto.getName()));
        assertThat(result.getId().toString(), equalTo(someTypeDto.getId()));
    }
}
