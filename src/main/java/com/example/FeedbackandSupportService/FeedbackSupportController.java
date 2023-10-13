package com.example.FeedbackandSupportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback-support")
public class FeedbackSupportController {
    private final FeedbackSupportService feedbackSupportService;

    @Autowired
    public FeedbackSupportController(FeedbackSupportService feedbackSupportService) {
        this.feedbackSupportService = feedbackSupportService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Void> sendFeedback(
            @RequestParam String senderEmail,
            @RequestParam String feedbackText) {
        feedbackSupportService.sendFeedback(senderEmail, feedbackText);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/support")
    public ResponseEntity<Void> sendSupportRequest(
            @RequestParam String senderEmail,
            @RequestParam String supportText) {
        feedbackSupportService.sendSupportRequest(senderEmail, supportText);
        return ResponseEntity.ok().build();
    }
}
