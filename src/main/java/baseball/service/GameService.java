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
    private static final int CLEAR = 3;
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

    /* 재시작 여부 확인 */
    public boolean restartGame() {
        int restartNumber = inputView.getRestartNumber();
        switch(restartNumber) {
            case 1 : //enum으로 빼려고 했지만 switch case문에는 상수 사용 불가
                createComputerNumber();
                return true;
            case 2 :
                outputView.notContinue();
                return false;
            default :
                throw new IllegalArgumentException("1또는 2의 값만 입력해주세요");
        }
    }

    /* 끝났는지 확인 */
    public boolean isEnd() {
        if(strike() == CLEAR) {
            endGame();
            return true;
        }
        return false;
    }


}
