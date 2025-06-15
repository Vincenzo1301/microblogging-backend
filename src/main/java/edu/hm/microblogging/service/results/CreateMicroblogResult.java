package edu.hm.microblogging.service.results;

import static edu.hm.microblogging.service.results.CreateMicroblogResult.Status.SUCCESS;

public record CreateMicroblogResult(String id, Status status, String message) {

  public enum Status {
    SUCCESS
  }

  public static CreateMicroblogResult success(String id, String message) {
    return new CreateMicroblogResult(id, SUCCESS, message);
  }
}
