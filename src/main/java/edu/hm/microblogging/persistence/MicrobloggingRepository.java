package edu.hm.microblogging.persistence;

import edu.hm.microblogging.model.Microblog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicrobloggingRepository extends JpaRepository<Microblog, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find microblogs by userId:
    // List<Microblog> findByUserId(String userId);
}
