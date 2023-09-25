package efub.session.test.controller;

import efub.session.test.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("/score/{value}")
    public String score(@PathVariable Long value) {
        return scoreService.doScore(value);
    }
}
