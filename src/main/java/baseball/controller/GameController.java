package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    /* 실행 컨트롤러 */
    public void run() {
        gameService.init();
        boolean isContinue = true;
        do {
            gameService.inputNumber();
            System.out.println(gameService.output());
            if (gameService.isEnd()) {
               isContinue = gameService.restartGame();
            }
        }while(isContinue);
    }
}
