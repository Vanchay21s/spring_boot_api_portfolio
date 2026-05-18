package project.portfolio.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileDTO {

    private Long id;
    private String username;
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private String aboutMe;
    private String profile;
}
