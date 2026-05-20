package project.portfolio.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table("profile")
public class Profile {

    @Id
    private Long id;
    private String username;
    @Column("full_name")
    private String fullName;
    @Column("date_of_birth")
    private LocalDate dateOfBirth;
    private String email;
    @Column("phone_number")
    private String phoneNumber;
    private String address;
    @Column("about_me")
    private String aboutMe;
    private String profile;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

}
