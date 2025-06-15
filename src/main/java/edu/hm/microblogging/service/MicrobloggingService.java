package edu.hm.microblogging.service;

import edu.hm.microblogging.service.results.CreateMicroblogResult;
import edu.hm.microblogging.service.results.ReadAllMicroblogsResult;

public interface MicrobloggingService {

  /**
   * Creates a new microblog post.
   *
   * @param userId the ID of the user creating the microblog
   * @param content the content of the microblog
   * @return a result object containing the status and message of the operation
   */
  CreateMicroblogResult createMicroblog(String userId, String content);

  /**
   * Reads all microblogs.
   *
   * @return a result object containing the status and list of microblogs
   */
  ReadAllMicroblogsResult readAllMicroblogs();
}
