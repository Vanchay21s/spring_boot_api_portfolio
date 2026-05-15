package project.portfolio.reposity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.portfolio.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
