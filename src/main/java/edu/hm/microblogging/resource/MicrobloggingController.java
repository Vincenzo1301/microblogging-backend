package edu.hm.microblogging.resource;

import static java.lang.Long.parseLong;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import edu.hm.microblogging.service.impl.MicrobloggingServiceImpl;
import edu.hm.microblogging.service.requests.CreateMicroblogRequest;
import edu.hm.microblogging.service.requests.EditMicroblogRequest;
import edu.hm.microblogging.service.results.ReadMicroblogResult;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/microblogging")
public class MicrobloggingController {

  private final MicrobloggingServiceImpl microbloggingService;

  public MicrobloggingController(MicrobloggingServiceImpl microbloggingService) {
    this.microbloggingService = microbloggingService;
  }

  @PostMapping
  public ResponseEntity<String> createMicroblog(@Valid @RequestBody CreateMicroblogRequest request) {
    var result = microbloggingService.createMicroblog(parseLong(request.getUserId()), request.getContent());
    return ResponseEntity.status(CREATED).body(result.message());
  }

  @GetMapping
  public ResponseEntity<List<ReadMicroblogResult>> readAllMicroblogs() {
    return ResponseEntity.ok(microbloggingService.readAllMicroblogs());
  }

  @PutMapping
  public ResponseEntity<String> editMicroblog(@Valid @RequestBody EditMicroblogRequest request) {
    var result = microbloggingService.editMicroblog(parseLong(request.userId()), parseLong(request.microblogId()), request.content());
    return ResponseEntity.status(OK).body(result.message());
  }
}
