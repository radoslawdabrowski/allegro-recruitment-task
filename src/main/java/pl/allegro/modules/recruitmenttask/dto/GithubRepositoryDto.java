package pl.allegro.modules.recruitmenttask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GithubRepositoryDto {

    @JsonProperty(value = "full_name")
    private String fullName;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "clone_url")
    private String cloneUrl;

    @JsonProperty(value = "stargazers_count")
    private Integer stars;

    @JsonProperty(value = "created_at")
    private Date createdAt;

}
