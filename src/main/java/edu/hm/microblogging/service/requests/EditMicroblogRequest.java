package edu.hm.microblogging.service.requests;

// TODO Add validation annotations as needed
public record EditMicroblogRequest(String userId, String microblogId, String content) {}
