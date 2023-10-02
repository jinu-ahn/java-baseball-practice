package baseball.view;

import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputView {
    private final OutputView outputView = new OutputView();
    Scanner sc = new Scanner(System.in);
    /* 사용자 입력 값 넣기 */
    public Player getInputNumber() {
        outputView.inputNumber();
        String number = Console.readLine();
        return new Player(number);
    }

    /* 재시작 , 종료 번호 받기 */
    public int getRestartNumber() {
        int number = Integer.parseInt(Console.readLine());
        return number;
    }
}
