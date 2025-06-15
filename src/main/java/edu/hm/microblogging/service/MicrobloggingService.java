package edu.hm.microblogging.service;

import edu.hm.microblogging.service.results.CreateMicroblogResult;
import edu.hm.microblogging.service.results.EditMicroblogResult;
import edu.hm.microblogging.service.results.ReadMicroblogResult;
import java.util.List;

/**
 * Service interface for managing microblogs.
 * Provides methods to create, read, and edit microblog posts.
 */
public interface MicrobloggingService {

  /**
   * Creates a new microblog post.
   *
   * @param userId the ID of the user creating the microblog
   * @param content the content of the microblog
   * @return a result object containing the status and message of the operation
   */
  CreateMicroblogResult createMicroblog(Long userId, String content);

  /**
   * Reads all microblogs.
   *
   * @return a result object containing the status and list of microblogs
   */
  List<ReadMicroblogResult> readAllMicroblogs();

  /**
   * Edits an existing microblog post.
   *
   * @param userId the ID of the user editing the microblog. Must match the user who created the microblog.
   * @param microblogId the ID of the microblog to edit
   * @param newContent the new content for the microblog
   * @return a result object containing the status and message of the operation
   */
  EditMicroblogResult editMicroblog(Long userId, Long microblogId, String newContent);
}
