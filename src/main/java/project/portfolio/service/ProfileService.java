package project.portfolio.service;

import project.portfolio.dto.ProfileDTO;
import reactor.core.publisher.Mono;

public interface ProfileService {
    Mono<ProfileDTO> createProfile(ProfileDTO profileDTO);
}
