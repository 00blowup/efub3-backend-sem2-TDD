package efub.session.test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ScoreServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ScoreService scoreService;

    // 일반적인 테스트 케이스를 하나 작성
    @Test
    public void scoreServiceTest() {
        // given
        Long value1 = 87L;

        // when, then
        assertThat(scoreService.doScore(value1)).isEqualTo("B");
    }

    // 비정상 데이터에 대한 테스트 케이스를 작성
    @Test
    public void abnormalScoreTest1() {
        // given
        Long value2 = -2L;

        //when, then
        assertThat(scoreService.doScore(value2)).isEqualTo("Insert a number from 0 to 100");
    }

    @Test
    public void abnormalScoreTest2() {
        // given
        Long value3 = 200L;

        //when, then
        assertThat(scoreService.doScore(value3)).isEqualTo("Insert a number from 0 to 100");
    }

}

