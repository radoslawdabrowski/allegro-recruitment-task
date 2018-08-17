package pl.allegro.modules.recruitmenttask.converter.impl;

import pl.allegro.modules.recruitmenttask.converter.DtoConverter;
import pl.allegro.modules.recruitmenttask.dto.GithubRepositoryDto;
import pl.allegro.modules.recruitmenttask.dto.GithubResponseDto;
import pl.allegro.utils.annotations.Converter;

@Converter
public class GithubDtoConverterImpl implements DtoConverter<GithubRepositoryDto, GithubResponseDto> {

    /**
     * @see DtoConverter#createDtoFromEntity(Object)
     */
    @Override
    public GithubResponseDto createDtoFromEntity(GithubRepositoryDto entity) {
        GithubResponseDto dto = new GithubResponseDto();
        dto.setCloneUrl(entity.getCloneUrl());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setDescription(entity.getDescription());
        dto.setFullName(entity.getFullName());
        dto.setStars(entity.getStars());
        return dto;
    }

    /**
     * @see DtoConverter#createEntityFromDto(Object)
     */
    @Override
    public GithubRepositoryDto createEntityFromDto(GithubResponseDto dto) {
        return updateEntity(new GithubRepositoryDto(), dto);
    }

    /**
     * @see DtoConverter#updateEntity(Object, Object)
     */
    @Override
    public GithubRepositoryDto updateEntity(GithubRepositoryDto githubRepositoryDto, GithubResponseDto githubResponseDto) {
        return null;
    }

}
