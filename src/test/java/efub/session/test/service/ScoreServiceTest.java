package efub.session.test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ScoreServiceTest {

    @InjectMocks
    private ScoreService scoreService;

    // 일반적인 테스트 케이스(높은 점수, A)를 작성
    @Test
    public void doScore_GivenHighScore_ReturnsGradeA() throws Exception {
        // given
        final Long HIGH_SCORE = 95L;
        final String GRADE_A = "A";

        // when, then
        assertThat(scoreService.doScore(HIGH_SCORE)).isEqualTo(GRADE_A);
    }

    // 일반적인 테스트 케이스(낮은 점수, F)를 작성
    @Test
    public void doScore_GivenLowScore_ReturnsGradeF() throws Exception {
        // given
        final Long LOW_SCORE = 20L;
        final String GRADE_F = "F";

        // when, then
        assertThat(scoreService.doScore(LOW_SCORE)).isEqualTo(GRADE_F);
    }


    // 비정상 데이터(음수)에 대한 테스트 케이스를 작성
    @Test
    public void doScore_GivenMinusScore_ReturnsWarningPhrase() throws Exception {
        // given
        final Long MINUS_SCORE = -2L;
        final String WARNING_PHRASE = "Insert a number from 0 to 100";

        // when, then
        assertThat(scoreService.doScore(MINUS_SCORE)).isEqualTo(WARNING_PHRASE);
    }

    // 비정상 데이터(100점을 초과)에 대한 테스트 케이스를 작성
    @Test
    public void doScore_GivenTooHighScore_ReturnsWarningPhrase() throws Exception {
        // given
        final Long TOO_HIGH_SCORE = 200L;
        final String WARNING_PHRASE = "Insert a number from 0 to 100";

        // when, then
        assertThat(scoreService.doScore(TOO_HIGH_SCORE)).isEqualTo(WARNING_PHRASE);
    }

}

