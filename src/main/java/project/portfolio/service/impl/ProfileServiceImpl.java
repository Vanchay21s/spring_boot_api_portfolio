package project.portfolio.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import project.portfolio.dto.ProfileDTO;
import project.portfolio.mapper.ProfileMapper;
import project.portfolio.model.Profile;
import project.portfolio.repository.ProfileRepository;
import project.portfolio.service.ProfileService;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {


    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Override
    public Mono<ProfileDTO> createProfile(ProfileDTO profileDTO) {
        Profile profile = profileMapper.toProfile(profileDTO);
        Mono<ProfileDTO> result = profileRepository.save(profile)
                .map(data -> profileMapper.toProfileDTO(data))
                .onErrorResume(DuplicateKeyException.class, error -> {
                    System.out.println("Caught duplicate email error: " + error.getMessage());
                    return Mono.error(new IllegalArgumentException("That email address is already registered."));
                });
        return result;
    }
}
