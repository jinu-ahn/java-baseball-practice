package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.Result.STRIKE;
import static baseball.util.Result.BALL;
import static baseball.util.Result.NOTHING;

public class GameService {
    private final OutputView outputView;
    private final InputView inputView;
    private List<Integer> computerNumber;

    private Player player;
    private List<Integer> playerNumber;

    public GameService() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        createComputerNumber();
    }

    /* 컴퓨터 숫자를 List에 저장하기 */
    public void createComputerNumber(){
        this.computerNumber = new Computer().getNumbers();
    }

    /* 게임 시작 뷰 */
    public void init() {
        outputView.init();
    }

    /* 게임 종료 뷰 */
    private void endGame() {
        outputView.endGame();
        outputView.restart();
    }

    /* 입력받은 값을 List에 저장하기 */
    public void inputNumber() {
        player = inputView.getInputNumber();
        playerNumber = player.getAnswer();
    }


}
