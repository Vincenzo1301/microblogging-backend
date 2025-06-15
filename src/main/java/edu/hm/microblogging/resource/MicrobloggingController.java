package edu.hm.microblogging.resource;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import edu.hm.microblogging.service.impl.MicrobloggingServiceImpl;
import edu.hm.microblogging.service.requests.CreateMicroblogRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/microblogging")
public class MicrobloggingController {

  private final MicrobloggingServiceImpl microbloggingService;

  public MicrobloggingController(MicrobloggingServiceImpl microbloggingService) {
    this.microbloggingService = microbloggingService;
  }

  @PostMapping
  public ResponseEntity<String> createMicroblog(
      @Valid @RequestBody CreateMicroblogRequest request) {
    var result = microbloggingService.createMicroblog(request.getUserId(), request.getContent());
    return ResponseEntity.status(CREATED).body(result.message());
  }

  @GetMapping
  public ResponseEntity<?> readAllMicroblogs() {
    var result = microbloggingService.readAllMicroblogs();
    return ResponseEntity.status(OK).body(result.readMicroblogResults());
  }
}
