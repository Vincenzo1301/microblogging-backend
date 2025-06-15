package edu.hm.microblogging.service.requests;

import jakarta.validation.constraints.NotBlank;

public class CreateMicroblogRequest {

  @NotBlank(message = "User ID cannot be blank")
  private String userId;

  @NotBlank(message = "Content cannot be blank")
  private String content;

  public CreateMicroblogRequest() {}

  public CreateMicroblogRequest(String userId, String content) {

    this.userId = userId;
    this.content = content;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
