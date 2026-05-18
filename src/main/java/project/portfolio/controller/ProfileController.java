package project.portfolio.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.portfolio.dto.ProfileDTO;
import project.portfolio.service.ProfileService;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/profile")
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping
    public Mono<ProfileDTO> createProfile(@RequestBody ProfileDTO profileDTO){
        return profileService.createProfile(profileDTO);
    }
}
