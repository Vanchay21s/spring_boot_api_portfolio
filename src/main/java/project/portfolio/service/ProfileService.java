package project.portfolio.service;

import project.portfolio.dto.ProfileDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfileService {
    Mono<ProfileDTO> createProfile(ProfileDTO profileDTO);

    Flux<ProfileDTO> getAllProfile();

    Mono<ProfileDTO> getProfileByID(Long id);

    Mono<ProfileDTO> updateProfile(Long id, ProfileDTO profileDTO);

    Mono<Void> deleteProfile(Long id);

}
