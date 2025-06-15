package edu.hm.microblogging.service.impl;

import static edu.hm.microblogging.service.results.EditMicroblogResult.editTimeExpired;
import static edu.hm.microblogging.service.results.EditMicroblogResult.notFound;
import static edu.hm.microblogging.service.results.EditMicroblogResult.success;
import static java.time.Instant.now;

import edu.hm.microblogging.model.Microblog;
import edu.hm.microblogging.persistence.MicrobloggingRepository;
import edu.hm.microblogging.service.MicrobloggingService;
import edu.hm.microblogging.service.results.CreateMicroblogResult;
import edu.hm.microblogging.service.results.EditMicroblogResult;
import edu.hm.microblogging.service.results.ReadMicroblogResult;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MicrobloggingServiceImpl implements MicrobloggingService {

  private static final long EDIT_TIME_LIMIT_SECONDS = 300;

  private final MicrobloggingRepository microbloggingRepository;

  public MicrobloggingServiceImpl(MicrobloggingRepository microbloggingRepository) {
    this.microbloggingRepository = microbloggingRepository;
  }

  @Override
  public CreateMicroblogResult createMicroblog(Long userId, String content) {
    var microblog = new Microblog(userId, content);
    var createdMicroblog = microbloggingRepository.save(microblog);
    return new CreateMicroblogResult(createdMicroblog.getId().toString(), "Microblog created successfully", createdMicroblog.getCreatedAt().toString());
  }

  @Override
  public List<ReadMicroblogResult> readAllMicroblogs() {
    return microbloggingRepository.findAll().stream().map(mb -> new ReadMicroblogResult(mb.getId(), mb.getUserId(), mb.getContent(), mb.getCreatedAt().toString())).toList();
  }

  @Override
  public EditMicroblogResult editMicroblog(Long userId, Long microblogId, String newContent) {
    var microblog = microbloggingRepository.findByIdAndUserId(microblogId, userId);
    if (microblog.isEmpty()) return notFound(userId, microblogId);

    var editTimeLimitExceeded = now().isAfter(microblog.get().getCreatedAt().toInstant().plusSeconds(EDIT_TIME_LIMIT_SECONDS));
    if (editTimeLimitExceeded) return editTimeExpired(microblogId);

    var existingMicroblog = microblog.get();
    existingMicroblog.setContent(newContent);
    var editedMicroblog = microbloggingRepository.save(existingMicroblog);
    return success(editedMicroblog.getId(), editedMicroblog.getCreatedAt().toString());
  }
}
