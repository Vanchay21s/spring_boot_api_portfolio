package project.portfolio.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import project.portfolio.dto.SkillRequest;
import project.portfolio.dto.SkillResponse;
import project.portfolio.model.Skill;
import project.portfolio.reposity.SkillRepository;
import project.portfolio.service.SkillService;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// Step 1 call @Service and @Slf4j
@Service
@Slf4j
public class SkillServiceImpl implements SkillService {

    // Step 2
    private final SkillRepository skillRepository;
    // Step 3
    public SkillServiceImpl(SkillRepository skillRepository){
        this.skillRepository =skillRepository;
    }
    // Step 4
    @Override
    public void create(SkillRequest skillRequest) {

        Skill skill = new Skill();

        skill.setName(skillRequest.getName());
        skill.setRating(skillRequest.getRating());

        skillRepository.save(skill);
    }

    @Override
    public void update(Long id, SkillRequest skillRequest) {

        Optional<Skill> skill = skillRepository.findById(id);
        if(skill.isEmpty()){
            log.info("Skill with ID: {} not found", id);
            return;
        }

        Skill skillUpdate = skill.get();
        skillUpdate.setName(skillRequest.getName());
        skillUpdate.setRating(skillRequest.getRating());

        skillRepository.saveAndFlush(skillUpdate);
    }

    @Override
    public void delete(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public SkillResponse getById(Long id) {

        SkillResponse skillResponse = new SkillResponse();

        Optional<Skill> skill = skillRepository.findById(id);
        if(skill.isEmpty()){
            log.info("Skill with ID: {} not found..", id);
            return skillResponse;
        }
        skillResponse.setId(skill.get().getId());
        skillResponse.setName(skill.get().getName());
        skillResponse.setRating(skill.get().getRating());
        return  skillResponse;

    }

    @Override
    public List<SkillResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<SkillResponse> skillResponse = new ArrayList<>();


        List<Skill> skill = skillRepository.findAll(pageable);
        if(skill.isEmpty()){
            log.info("not skill found");
            return skillResponse;
        }
        for (var s : skill){
            SkillResponse data = new SkillResponse();
            data.setId(s.getId());
            data.setName(s.getName());
            data.setRating(s.getRating());

            skillResponse.add(data);
        }
        return skillResponse;
    }
}
