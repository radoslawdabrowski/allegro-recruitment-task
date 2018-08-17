package pl.allegro.modules.recruitmenttask.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class GithubResponseDto {

    private String fullName;
    private String description;
    private String cloneUrl;
    private Integer stars;
    private Date createdAt;

}
