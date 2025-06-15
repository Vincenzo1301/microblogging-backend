package edu.hm.microblogging.service.results;

import static edu.hm.microblogging.service.results.ReadAllMicroblogsResult.Status.SUCCESS;

import java.util.List;

public record ReadAllMicroblogsResult(Status status, List<ReadMicroblogResult> readMicroblogResults) {

  public enum Status {
    SUCCESS,
  }

  public record ReadMicroblogResult(String id, String userId, String content, String createdAt) {}

  public static ReadAllMicroblogsResult success(List<ReadMicroblogResult> readMicroblogResults) {
    return new ReadAllMicroblogsResult(SUCCESS, readMicroblogResults);
  }
}
