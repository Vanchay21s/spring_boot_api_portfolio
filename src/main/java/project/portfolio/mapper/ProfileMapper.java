package project.portfolio.mapper;

import org.springframework.stereotype.Component;
import project.portfolio.dto.ProfileDTO;
import project.portfolio.model.Profile;

@Component
public class ProfileMapper {
    // DTO -> Entity
    public Profile toProfile(ProfileDTO profileDTO){
        Profile profile = new Profile();

        profile.setUsername(profileDTO.getUsername());
        profile.setFullName(profileDTO.getFullName());
        profile.setDateOfBirth(profileDTO.getDateOfBirth());
        profile.setEmail(profileDTO.getEmail());
        profile.setPhoneNumber(profileDTO.getPhoneNumber());
        profile.setAddress(profileDTO.getAddress());
        profile.setAboutMe(profileDTO.getAboutMe());
        profile.setProfile(profileDTO.getProfile());
        return profile;
    }

    // Eniity -> DTO
    public ProfileDTO toProfileDTO(Profile profile){
        ProfileDTO dto = new ProfileDTO();
        dto.setId(profile.getId());
        dto.setUsername(profile.getUsername());
        dto.setFullName(profile.getFullName());
        dto.setDateOfBirth(profile.getDateOfBirth());
        dto.setEmail(profile.getEmail());
        dto.setPhoneNumber(profile.getPhoneNumber());
        dto.setAddress(profile.getAddress());
        dto.setAboutMe(profile.getAboutMe());
        dto.setProfile(profile.getProfile());

        return dto;
    }
    // Update existing entity
    public void updateProfile(Profile profile,
                              ProfileDTO profileDTO){

        profile.setId(profileDTO.getId());
        profile.setUsername(profileDTO.getUsername());
        profile.setFullName(profileDTO.getFullName());
        profile.setDateOfBirth(profileDTO.getDateOfBirth());
        profile.setEmail(profileDTO.getEmail());
        profile.setPhoneNumber(profileDTO.getPhoneNumber());
        profile.setAddress(profileDTO.getAddress());
        profile.setAboutMe(profileDTO.getAboutMe());
        profile.setProfile(profileDTO.getProfile());
    }
}
