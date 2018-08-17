package pl.allegro.modules.recruitmenttask.converter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.allegro.modules.recruitmenttask.converter.impl.GithubDtoConverterImpl;
import pl.allegro.modules.recruitmenttask.dto.GithubRepositoryDto;
import pl.allegro.modules.recruitmenttask.dto.GithubResponseDto;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class DtoConverterTests {

    @Test
    public void assertDtoConvert() {
        DtoConverter<GithubRepositoryDto, GithubResponseDto> dtoConverter = new GithubDtoConverterImpl();
        GithubRepositoryDto repositoryDto = new GithubRepositoryDto();
        repositoryDto.setDescription("description");
        repositoryDto.setFullName("Full name");
        repositoryDto.setCloneUrl("http://someurl.com");
        GithubResponseDto dto = dtoConverter.createDtoFromEntity(repositoryDto);

        assertThat(dto.getFullName()).isEqualTo(repositoryDto.getFullName());
        assertThat(dto.getCloneUrl()).isEqualTo(repositoryDto.getCloneUrl());
        assertThat(dto.getDescription()).isEqualTo(repositoryDto.getDescription());
        assertThat(dto.getCreatedAt()).isEqualTo(repositoryDto.getCreatedAt());
        assertThat(dto.getStars()).isEqualTo(repositoryDto.getStars());
    }

}
