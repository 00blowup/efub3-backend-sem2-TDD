package efub.session.test.service;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    public String doScore(Long value) {
        String result = "";
        if (value > 100 || value < 0) result = "Insert a number from 0 to 100"; // 코드 추가
        else if (value >= 90) result = "A";
        else if (value >= 80) result = "B";
        else if (value >= 70) result = "C";
        else if (value >= 60) result = "D";
        else result = "F";

        return result;
    }
}
