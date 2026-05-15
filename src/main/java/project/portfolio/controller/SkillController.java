package project.portfolio.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.portfolio.dto.SkillRequest;
import project.portfolio.service.SkillService;

@Slf4j
@RestController
public class SkillController {

    private final SkillService skillService;
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("v1/skill")
    public String hello(){
        return "Hello Chai";
    }

    @PostMapping("v1/skill")
    public ResponseEntity<Object> createSkill(@RequestBody SkillRequest skillRequest){
        log.info("creating skill with request: {}", skillRequest);
        skillService.create(skillRequest);
        return  ResponseEntity.ok().build();
    }
}
