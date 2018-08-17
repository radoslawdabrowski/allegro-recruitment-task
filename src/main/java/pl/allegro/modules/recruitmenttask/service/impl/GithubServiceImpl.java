package pl.allegro.modules.recruitmenttask.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.allegro.modules.recruitmenttask.converter.DtoConverter;
import pl.allegro.modules.recruitmenttask.dto.GithubRepositoryDto;
import pl.allegro.modules.recruitmenttask.dto.GithubResponseDto;
import pl.allegro.modules.recruitmenttask.service.GithubService;
import pl.allegro.utils.constraints.Github;

@Slf4j
@Service
public class GithubServiceImpl implements GithubService {

    private final DtoConverter<GithubRepositoryDto, ? extends GithubResponseDto> dtoConverter;

    @Autowired
    public GithubServiceImpl(DtoConverter<GithubRepositoryDto, ? extends GithubResponseDto> dtoConverter) {
        this.dtoConverter = dtoConverter;
    }

    /**
     * @see GithubService#findRepository(String, String)
     */
    @Override
    public GithubResponseDto findRepository(String owner, String name) {
        GithubRepositoryDto dto = new RestTemplate().getForObject(String.format(Github.REPOS, owner, name), GithubRepositoryDto.class);
        return dtoConverter.createDtoFromEntity(dto);
    }

}
