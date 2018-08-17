package pl.allegro.modules.recruitmenttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.allegro.modules.recruitmenttask.dto.GithubResponseDto;
import pl.allegro.modules.recruitmenttask.service.GithubService;
import pl.allegro.utils.constraints.Directory;

@RestController
@RequestMapping(path = Directory.GITHUB_REPOSITORIES)
public class GithubController {

    private final GithubService githubService;

    @Autowired
    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    /**
     * Rest enpoint getting github repository informations by user's name and name of his repository
     *
     * @param owner    name of the github user
     * @param repoName name of the reposiotry
     * @return {@link GithubResponseDto}
     */
    @RequestMapping(path = Directory.REPOSITORY, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GithubResponseDto> findRepository(@PathVariable(name = "owner") String owner, @PathVariable(name = "repository-name") String repoName) {
        return new ResponseEntity<>(githubService.findRepository(owner, repoName), HttpStatus.OK);
    }

}
