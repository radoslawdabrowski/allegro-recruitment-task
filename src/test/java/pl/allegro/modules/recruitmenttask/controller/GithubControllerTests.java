package pl.allegro.modules.recruitmenttask.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.actuate.autoconfigure.LocalManagementPort;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import pl.allegro.modules.recruitmenttask.dto.GithubResponseDto;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GithubControllerTests {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void assertResponse() {
        GithubResponseDto dto = new RestTemplate().getForObject(String.format("http://localhost:%s/repositories/%s/%s", randomServerPort, "radoslawdabrowski", "spring-boot-example"), GithubResponseDto.class);
        assertThat(dto.getFullName()).isEqualTo("radoslawdabrowski/spring-boot-example");
    }

}