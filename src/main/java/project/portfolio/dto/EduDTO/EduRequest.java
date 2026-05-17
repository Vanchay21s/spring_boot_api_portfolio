package project.portfolio.dto.EduDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EduRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("major")
    private String major;
    @JsonProperty("gpa")
    private String gpa;
    @JsonProperty("year")
    private String year;
}
