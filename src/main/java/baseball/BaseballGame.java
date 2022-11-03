package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

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

    private boolean isStrike(List<Integer> inputNumbers, List<Integer> answer, int index) {
        return inputNumbers.get(index) == answer.get(index);
    }

    public int getStrikeCount(List<Integer> inputNumbers, List<Integer> answer) {
        int count = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            if (isStrike(inputNumbers, answer, i)) {
                count++;
            }
        }
        return count;
    }

}
