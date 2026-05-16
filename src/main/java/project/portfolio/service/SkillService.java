package project.portfolio.service;

import project.portfolio.dto.SkillRequest;
import project.portfolio.dto.SkillResponse;

import java.util.List;

public interface SkillService {

    void create(SkillRequest skillRequest);
    void update(Long id, SkillRequest skillRequest);
    void delete(Long id);
    SkillResponse getById(Long id);
    List<SkillResponse> getAll(int page, int size);
}
