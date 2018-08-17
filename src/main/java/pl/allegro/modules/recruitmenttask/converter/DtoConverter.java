package pl.allegro.modules.recruitmenttask.converter;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * See example of more complex solution on my github repository
 * @see <a href="https://github.com/radoslawdabrowski/spring-boot-example">http://github.com</a>
 */
public interface DtoConverter<ENTITY, DTO> {

    /**
     * convert entity object to DTO
     *
     * @param entity ENTITY
     * @return DTO
     */
    DTO createDtoFromEntity(ENTITY entity);

    /**
     * convert DTO to entity object
     *
     * @param dto DTO
     * @return ENTITY
     */
    ENTITY createEntityFromDto(DTO dto);

    /**
     * Method update existing entity by converter version
     *
     * @param entity ENTITY
     * @param dto    DTO
     * @return ENTITY
     */
    ENTITY updateEntity(ENTITY entity, DTO dto);

    /**
     * Method creates returns set of dtos by set of entities
     *
     * @param input SET<ENTITY>
     * @return SET<DTO>
     */
    default Set<DTO> createFromEntities(final Set<ENTITY> input) {
        return input.stream().map(this::createDtoFromEntity).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Method creates returns set of entities by set of dtos
     *
     * @param input SET<DTO>
     * @return SET<ENTITY>
     */
    default Set<ENTITY> createFromDtos(final Set<DTO> input) {
        return input.stream().map(this::createEntityFromDto).collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
