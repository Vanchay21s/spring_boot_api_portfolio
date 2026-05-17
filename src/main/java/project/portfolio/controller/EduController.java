package project.portfolio.controller;

import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import project.portfolio.dto.ApiResponse;
import project.portfolio.dto.EduDTO.EduRequest;
import project.portfolio.dto.EduDTO.EduResponse;
import project.portfolio.service.EducationService;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;


@RestController
@Slf4j
public class EduController {
    private final EducationService educationService;
    
    public EduController(EducationService educationService){
        this.educationService = educationService;
    }

    @PostMapping("v1/edu")
    public ResponseEntity<Object> createEdu(@RequestBody EduRequest eduRequest){
        log.info("creating education with request: {}", eduRequest);
        educationService.create(eduRequest);
        return  ResponseEntity.ok(eduRequest);
    }

    @GetMapping("v1/edu/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        EduResponse edu = educationService.getById(Long.parseLong(id));
        return ResponseEntity.ok(edu);
    }
    
}
