package project.portfolio.service;

import java.util.List;

import project.portfolio.dto.skillDTO.SkillRequest;
import project.portfolio.dto.skillDTO.SkillResponse;

public interface SkillService {

    void create(SkillRequest skillRequest);
    void update(Long id, SkillRequest skillRequest);
    void delete(Long id);
    SkillResponse getById(Long id);
    List<SkillResponse> getAll();
}
