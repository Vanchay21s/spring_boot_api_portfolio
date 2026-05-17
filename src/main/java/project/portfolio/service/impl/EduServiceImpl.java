package project.portfolio.service.impl;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import project.portfolio.dto.EduDTO.EduRequest;
import project.portfolio.model.Education;
import project.portfolio.reposity.EducationRepository;
import project.portfolio.service.EducationService;

@Service
@Slf4j
public class EduServiceImpl implements EducationService {
    private final EducationRepository educationRepository;
    
    public EduServiceImpl(EducationRepository educationRepository){
        this.educationRepository = educationRepository;
    }
    @Override
    public void create(EduRequest eduRequest) {
        Education edu = new Education();
        edu.setName(eduRequest.getName());
        edu.setLogo(eduRequest.getLogo());
        edu.setMajor(eduRequest.getMajor());
        edu.setGpa(eduRequest.getGpa());
        edu.setYear(eduRequest.getYear());

        educationRepository.save(edu);
    }
    
}
