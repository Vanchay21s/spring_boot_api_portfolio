package project.portfolio.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.portfolio.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {   
}
