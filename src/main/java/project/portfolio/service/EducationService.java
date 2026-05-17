package project.portfolio.service;

import project.portfolio.dto.EduDTO.EduRequest;
import project.portfolio.dto.EduDTO.EduResponse;

import java.util.List;

public interface EducationService {
    void create(EduRequest request);
    void update(Long id, EduRequest request);
    void delete(Long id);
    EduResponse getById(Long id);
    List<EduResponse> getAll();
}
