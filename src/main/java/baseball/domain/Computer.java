package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.Range.Number.LOWER_RANGE;
import static baseball.util.Range.Number.UPPER_RANGE;

public class Computer {
    private final int MAX_SIZE = 3;
    private List<Integer> numbers = new ArrayList<>();


    public Computer(){
        this.numbers = createRandomNumbers();
    }

    /* 랜덤한 서로다른 숫자 3개 생성 */
    private List<Integer> createRandomNumbers() {
        List<Integer> createNumbers = new ArrayList<>();

        while(createNumbers.size() < MAX_SIZE){
            int randomNumber = Randoms.pickNumberInRange(LOWER_RANGE.getRange(),UPPER_RANGE.getRange());
            if(!createNumbers.contains(randomNumber)){
                createNumbers.add(randomNumber);
            }
        }
        return createNumbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
