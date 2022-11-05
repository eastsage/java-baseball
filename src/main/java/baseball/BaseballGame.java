package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {
    private Player player;
    private Rule rule;
    private List<Integer> answer;
    private List<String> hint;
    private boolean wrongAnswer;

    public BaseballGame() {
        player = new Player();
        rule = new Rule();
        rule.print(Message.START.get());
    }
    public void start() {
        answer = rule.generateAnswer();
        wrongAnswer = true;
        do {
            rule.print(Message.INPUT.get());
            player.setNumber();
            rule.print(makeHint());
        } while (wrongAnswer);
        rule.print(Message.END.get());
    }

    private String makeHint() {
        if (gameSet(player.getNumber(), answer)) {
            wrongAnswer = false;
        }
        hint = new ArrayList<>();
        getBallCount(player.getNumber(), answer);
        getStrikeCount(player.getNumber(), answer);
        getNothing(player.getNumber(), answer);
        return String.join(" ", hint);
    }

    public void getStrikeCount(List<Integer> inputs, List<Integer> answer) {
        int count = 0;
        for (int i = 0; i < inputs.size(); i++) {
            if (isStrike(inputs, answer, i)) {
                count++;
            }
        }
        if (count != 0) {
            hint.add(String.valueOf(count) + "스트라이크");
        }
    }

    public void getBallCount(List<Integer> inputs, List<Integer> answer) {
        int count = 0;
        for (int i = 0; i < inputs.size(); i++) {
            if (answer.contains(inputs.get(i))) {
                count++;
            }
            if (isStrike(inputs, answer, i)) {
                count--;
            }
        }
        if (count != 0) {
            hint.add(String.valueOf(count) + "볼");
        }
    }

    private void getNothing(List<Integer> inputs, List<Integer> answer) {
        if (hint.isEmpty()) {
            hint.add("낫싱");
        }
        hint.add("\n");
    }

    private boolean isStrike(List<Integer> inputs, List<Integer> answer, int index) {
        return inputs.get(index) == answer.get(index);
    }

    public boolean gameSet(List<Integer> inputs, List<Integer> answer) {
        return Arrays.equals(inputs.toArray(), answer.toArray());
    }

}
