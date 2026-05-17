package project.portfolio.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.portfolio.dto.ApiResponse;
import project.portfolio.dto.skillDTO.SkillRequest;
import project.portfolio.dto.skillDTO.SkillResponse;
import project.portfolio.service.SkillService;

import java.util.List;

@Slf4j
@RestController
public class SkillController {

    private final SkillService skillService;
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("v1/skill")
    public ResponseEntity<ApiResponse<List<SkillResponse>>> findSkill(@RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "10") int size){
        log.info("Find Skill is successfully.");
        List<SkillResponse> skillResponses = skillService.getAll();
        ApiResponse<List<SkillResponse>> result = new ApiResponse<>(
                true,
                "Users fetched successfully",
                skillResponses);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

//    @DeleteMapping("v1/skill")
//    public ResponseEntity<?> deleteSkill(@PathVariable String id){
//        log.info("Deleted Skill with {}", id);
//        SkillResponse skillResponse = skillService.getById(Long.parseLong(id));
//        if(skillResponse == null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(skillResponse);
//    }

    @PostMapping("v1/skill")
    public ResponseEntity<Object> createSkill(@RequestBody SkillRequest skillRequest){
        log.info("creating skill with request: {}", skillRequest);
        skillService.create(skillRequest);
        return  ResponseEntity.ok(skillRequest);
    }

    @PutMapping("v1/skill/{id}")
    public ResponseEntity<Object> updateSkill(@RequestBody SkillRequest skillRequest,
                                              @PathVariable String id){
        log.info("Updated skill with ID: {} and request: {} ", id, skillRequest);
        skillService.update(Long.parseLong(id), skillRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("v1/skill/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable String id){
        log.info("Deleted Skill with {}", id);
        skillService.getById(Long.parseLong(id));
        return ResponseEntity.accepted().build();
    }

}
