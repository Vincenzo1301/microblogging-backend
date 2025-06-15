package edu.hm.microblogging.service.impl;

import static edu.hm.microblogging.service.results.CreateMicroblogResult.success;
import static edu.hm.microblogging.service.results.ReadAllMicroblogsResult.success;

import edu.hm.microblogging.model.Microblog;
import edu.hm.microblogging.persistence.MicrobloggingRepository;
import edu.hm.microblogging.service.MicrobloggingService;
import edu.hm.microblogging.service.results.CreateMicroblogResult;
import edu.hm.microblogging.service.results.ReadAllMicroblogsResult;
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
    return success(createdMicroblog.getId().toString(), "Microblog created successfully");
  }

  @Override
  public ReadAllMicroblogsResult readAllMicroblogs() {
    var microblogs = microbloggingRepository.findAll();
    var resultMicroblogs = microblogs.stream().map(mb -> new ReadAllMicroblogsResult.ReadMicroblogResult(mb.getId().toString(), mb.getUserId(), mb.getContent(), mb.getCreatedAt().toString())).toList();
    return success(resultMicroblogs);
  }
}
