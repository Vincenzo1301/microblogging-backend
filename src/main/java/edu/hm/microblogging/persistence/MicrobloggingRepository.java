package edu.hm.microblogging.persistence;

import edu.hm.microblogging.model.Microblog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MicrobloggingRepository extends JpaRepository<Microblog, Long> {

  Optional<Microblog> findByIdAndUserId(Long id, Long userId);
}
