package project.portfolio.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import project.portfolio.model.Profile;

public interface ProfileRepository
        extends ReactiveCrudRepository<Profile, Long> {
}
