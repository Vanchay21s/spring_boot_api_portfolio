package project.portfolio.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.portfolio.dto.ProfileDTO;
import project.portfolio.service.ProfileService;
import reactor.core.publisher.Flux;
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
    @GetMapping
    public Flux<ProfileDTO> getAllProfile(){
        return profileService.getAllProfile();
    }
    @GetMapping("/{id}")
    public Mono<ProfileDTO> getProfileById(@PathVariable String id){
        return profileService.getProfileByID(Long.parseLong(id));
    }

    @PutMapping("/{id}")
    public Mono<ProfileDTO> updateProfile(@PathVariable String id,
                                          @RequestBody ProfileDTO profileDTO){
        return profileService.updateProfile(Long.parseLong(id), profileDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable String id){
        return profileService.deleteProfile(Long.parseLong((id)));
    }

}
