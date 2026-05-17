package project.portfolio.controller;

import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project.portfolio.dto.ApiResponse;
import project.portfolio.dto.EduDTO.EduRequest;
import project.portfolio.service.EducationService;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Slf4j
public class EduController {
    private final EducationService educationService;
    
    public EduController(EducationService educationService){
        this.educationService = educationService;
    }

    @PostMapping("v1/education")
    public ResponseEntity<Object> createEdu(@RequestBody EduRequest eduRequest){
        log.info("creating education with request: {}", eduRequest);
        educationService.create(eduRequest);
        return  ResponseEntity.ok(eduRequest);
    }
    
}
