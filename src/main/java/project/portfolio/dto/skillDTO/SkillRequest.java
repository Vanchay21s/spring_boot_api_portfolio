package project.portfolio.dto.skillDTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SkillRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("logo")
    private String logo;

    @JsonProperty("rating")
    private BigDecimal rating;

}
