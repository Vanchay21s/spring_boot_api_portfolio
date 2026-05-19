package project.portfolio.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import project.portfolio.model.Profile;

@Repository
public interface ProfileRepository
        extends ReactiveCrudRepository<Profile, Long> {
}
