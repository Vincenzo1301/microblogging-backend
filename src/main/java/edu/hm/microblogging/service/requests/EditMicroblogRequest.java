package edu.hm.microblogging.service.requests;

public record EditMicroblogRequest(String userId, String microblogId, String content) {}
