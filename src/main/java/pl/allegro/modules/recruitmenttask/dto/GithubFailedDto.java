package pl.allegro.modules.recruitmenttask.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class GithubFailedDto{

    private boolean error;
    private String message;

    public GithubFailedDto(String message) {
        setError(true);
        setMessage(message);
    }
}
