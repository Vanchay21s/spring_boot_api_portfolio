package project.portfolio.service.impl;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import project.portfolio.dto.EduDTO.EduRequest;
import project.portfolio.dto.EduDTO.EduResponse;
import project.portfolio.model.Education;
import project.portfolio.reposity.EducationRepository;
import project.portfolio.service.EducationService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EduServiceImpl implements EducationService {
    private final EducationRepository educationRepository;
    
    public EduServiceImpl(EducationRepository educationRepository){
        this.educationRepository = educationRepository;
    }
    @Override
    public void create(EduRequest request) {
        Education edu = new Education();
        edu.setName(request.getName());
        edu.setLogo(request.getLogo());
        edu.setMajor(request.getMajor());
        edu.setGpa(request.getGpa());
        edu.setYear(request.getYear());

        educationRepository.save(edu);
    }

    @Override
    public void update(Long id, EduRequest request) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public EduResponse getById(Long id) {
        Optional<Education> edu = educationRepository.findById(id);
        EduResponse response = new EduResponse();
        response.setId(edu.get().getId());
        response.setName(edu.get().getName());
        response.setLogo(edu.get().getLogo());
        response.setGpa(edu.get().getGpa());
        response.setMajor(edu.get().getMajor());
        response.setYear(edu.get().getYear());
        response.setCreatedAt(edu.get().getCreatedAt());
        response.setUpdatedAt(edu.get().getUpdatedAt());

        return response;
    }

    @Override
    public List<EduResponse> getAll() {
        return List.of();
    }

}
