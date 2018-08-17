package pl.allegro.modules.recruitmenttask.service;

import pl.allegro.modules.recruitmenttask.dto.GithubResponseDto;

public interface GithubService {

    /**
     * service function for getting github repository informations
     *
     * @param owner {@link String} - name of the github user
     * @param name  {@link String} - name of owner's github repository
     * @return {@link GithubResponseDto} - dto object for github repository
     */
    GithubResponseDto findRepository(String owner, String name);

}
