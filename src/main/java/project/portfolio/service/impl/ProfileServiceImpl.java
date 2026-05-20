package project.portfolio.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.portfolio.dto.ProfileDTO;
import project.portfolio.mapper.ProfileMapper;
import project.portfolio.model.Profile;
import project.portfolio.repository.ProfileRepository;
import project.portfolio.service.ProfileService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Override
    public Mono<ProfileDTO> createProfile(ProfileDTO profileDTO) {
        Profile profile = profileMapper.toProfile(profileDTO);
        return profileRepository.save(profile)
                .map(profileMapper::toProfileDTO);
    }

    @Override
    public Flux<ProfileDTO> getAllProfile() {
        return profileRepository.findAll()
                .map(profileMapper::toProfileDTO);
    }

    @Override
    public Mono<ProfileDTO> getProfileByID(Long id) {
        return profileRepository.findById(id)
                .map(profileMapper::toProfileDTO);
    }

    @Override
    public Mono<ProfileDTO> updateProfile(Long id, ProfileDTO profileDTO) {
        return profileRepository.findById(id)
                .flatMap(existsProfile -> {

                    profileMapper.updateProfile(existsProfile, profileDTO);

                    return profileRepository.save(existsProfile);
                }).map(profileMapper::toProfileDTO);
    }

    @Override
    public Mono<Void> deleteProfile(Long id) {
        return profileRepository.deleteById(id);
    }
}
