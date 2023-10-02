package baseball;

import baseball.controller.GameController;
import baseball.domain.Computer;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();

        gameController.run();
    }
}
