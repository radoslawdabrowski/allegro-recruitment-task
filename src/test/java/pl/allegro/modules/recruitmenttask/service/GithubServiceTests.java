package pl.allegro.modules.recruitmenttask.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import pl.allegro.modules.recruitmenttask.dto.GithubRepositoryDto;
import pl.allegro.modules.recruitmenttask.dto.GithubResponseDto;
import pl.allegro.utils.constraints.Github;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubServiceTests {

    @Autowired
    private GithubService githubService;

    @Test
    public void assertGithubAPI() {
        GithubRepositoryDto dto = new RestTemplate().getForObject(String.format(Github.REPOS, "radoslawdabrowski", "spring-boot-example"), GithubRepositoryDto.class);
        assertThat(dto.getFullName()).isEqualTo("radoslawdabrowski/spring-boot-example");
    }

    @Test
    public void assertResponse() {
        GithubResponseDto dto = githubService.findRepository("radoslawdabrowski", "spring-boot-example");
        assertThat(dto.getFullName()).isEqualTo("radoslawdabrowski/spring-boot-example");
    }


}
