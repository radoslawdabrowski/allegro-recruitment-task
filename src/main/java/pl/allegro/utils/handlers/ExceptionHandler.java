package pl.allegro.utils.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import pl.allegro.modules.recruitmenttask.dto.GithubFailedDto;
import pl.allegro.utils.constraints.Directory;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@ControllerAdvice
public class ExceptionHandler implements ErrorController {

    @Autowired
    public ExceptionHandler(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public String getErrorPath() {
        return Directory.ERROR;
    }

    final
    private HttpServletRequest httpServletRequest;

    /**
     * todo all the raw strings with text should be of course in i18n with kind of MessageContainer getting proper string by locale from LocaleContextHolder     *
     */
    /**
     * handling a request with wrong url
     * @return {@link GithubFailedDto} - containing message
     */
    @RequestMapping(value = Directory.ERROR)
    public ResponseEntity<GithubFailedDto> pageNotFoundHandler() {
        return new ResponseEntity<>(new GithubFailedDto("Page not found"), HttpStatus.NOT_FOUND);
    }

    /**
     * handling bad request to github api
     * @param ex {@link HttpClientErrorException} exception thowed by {@link org.springframework.web.client.RestTemplate}
     * @return {@link GithubFailedDto} - containing message
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<GithubFailedDto> githubRepositoryNotFound(HttpClientErrorException ex) {
        ex.printStackTrace();
        switch (ex.getStatusCode()) {
            case FORBIDDEN: return new ResponseEntity<>(new GithubFailedDto("API rate limit exceeded"), HttpStatus.NOT_FOUND);
            case NOT_FOUND:
            default: return new ResponseEntity<>(new GithubFailedDto("Github repository not found"), HttpStatus.NOT_FOUND);
        }
    }

}
