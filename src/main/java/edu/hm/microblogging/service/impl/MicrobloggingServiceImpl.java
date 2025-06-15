package edu.hm.microblogging.service.impl;

import edu.hm.microblogging.model.Microblog;
import edu.hm.microblogging.persistence.MicrobloggingRepository;
import edu.hm.microblogging.service.MicrobloggingService;
import edu.hm.microblogging.service.results.CreateMicroblogResult;
import edu.hm.microblogging.service.results.ReadMicroblogResult;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MicrobloggingServiceImpl implements MicrobloggingService {

  private final MicrobloggingRepository microbloggingRepository;

  public MicrobloggingServiceImpl(MicrobloggingRepository microbloggingRepository) {
    this.microbloggingRepository = microbloggingRepository;
  }

  @Override
  public CreateMicroblogResult createMicroblog(String userId, String content) {
    var microblog = new Microblog(userId, content);
    var createdMicroblog = microbloggingRepository.save(microblog);
    return new CreateMicroblogResult(createdMicroblog.getId().toString(), "Microblog created successfully");
  }

  @Override
  public List<ReadMicroblogResult> readAllMicroblogs() {
    return microbloggingRepository.findAll().stream()
        .map(
            mb ->
                new ReadMicroblogResult(
                    mb.getId().toString(),
                    mb.getUserId(),
                    mb.getContent(),
                    mb.getCreatedAt().toString()))
        .toList();
  }
}
