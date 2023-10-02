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
    private static final int ZERO = 0;
    private final OutputView outputView;
    private final InputView inputView;
    private List<Integer> computerNumber;
    private Player player;
    private List<Integer> playerNumber;
    private StringBuilder sb;
    private int strike,ball;

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

    /* Strike 카운트 */
    private int strike() {
        int strike = 0;
        for(int i=0;i<3;i++){
            if(computerNumber.get(i).equals(playerNumber.get(i)))
                strike++;
        }
        return strike;
    }

    /* ball 카운트 */
    private int ball() {
        int ball = 0;
        for(int i=0;i<3;i++){
            if(!computerNumber.get(i).equals(playerNumber.get(i))
                    && computerNumber.contains(playerNumber.get(i))){
                ball++;
            }
        }
        return ball;
    }

    /* 결과값 리턴 */
    public String output() {
        sb = new StringBuilder();
        strike = strike();
        ball = ball();

        /* 하드코딩... 리팩토링 필요 */
        if(strike > ZERO && ball == ZERO)
            return sb.append(strike).append(STRIKE.getMessage()).toString();
        if(strike == ZERO && ball > ZERO)
            return sb.append(ball).append(BALL.getMessage()).toString();
        if(strike > ZERO && ball > ZERO)
            return sb.append(ball).append(BALL.getMessage()).append(" ")
                    .append(strike).append(STRIKE.getMessage()).toString();

        return sb.append(NOTHING.getMessage()).toString();
    }


}
