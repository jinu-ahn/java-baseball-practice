package baseball.view;

import static baseball.util.Message.INIT_MESSAGE;
import static baseball.util.Message.INPUT_NUMBER_MESSAGE;
import static baseball.util.Message.END_GAME_MESSAGE;
import static baseball.util.Message.RESTART_MESSAGE;
import static baseball.util.Message.NOT_CONTINUE_MESSAGE;


public class OutputView {
    public void init() {
        System.out.println(INIT_MESSAGE.getMessage());
    }

    public void inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE.getMessage());
    }

    public void endGame() {
        System.out.println(END_GAME_MESSAGE.getMessage());
    }

    public void restart() {
        System.out.println(RESTART_MESSAGE.getMessage());
    }

    public void notContinue() {
        System.out.println(NOT_CONTINUE_MESSAGE.getMessage());
    }

}
