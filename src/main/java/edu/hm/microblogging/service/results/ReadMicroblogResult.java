package edu.hm.microblogging.service.results;

public record ReadMicroblogResult(Long id, Long userId, String content, String createdAt) {}
