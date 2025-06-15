package edu.hm.microblogging.service.results;

import static edu.hm.microblogging.service.results.EditMicroblogResult.Status.SUCCESS;

public record EditMicroblogResult(Long id, Status status, String message, String updatedAt) {

  public enum Status {
    SUCCESS,
    NOT_FOUND,
    EDIT_TIME_EXPIRED,
  }

  public static EditMicroblogResult success(Long id, String updatedAt) {
    return new EditMicroblogResult(id, SUCCESS, "Microblog edited successfully", updatedAt);
  }

  public static EditMicroblogResult notFound(Long id, Long userId) {
    return new EditMicroblogResult(id, Status.NOT_FOUND, "Microblog with ID " + id + " not found for user " + userId + ".", null);
  }

  public static EditMicroblogResult editTimeExpired(Long id) {
    return new EditMicroblogResult(id, Status.EDIT_TIME_EXPIRED, "Edit time expired for microblog with ID " + id + ".", null);
  }
}
