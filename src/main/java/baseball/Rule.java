package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Rule {
    private List<Integer> answer;

    public Rule() {
        this.answer = generateAnswer();
    }

    public void print(String message) {
        System.out.print(message);
    }

    public List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}
