package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static baseball.util.Range.REGEXP.REGEXP;

public class Player {
    private final Pattern pattern = Pattern.compile(REGEXP.getRegexp());
    private List<Integer> answer = new ArrayList<>();


    public Player(String number) {
        this.answer = validationAnswerNumbers(number);
    }

    /* 사용자가 입력한 숫자 검증 */
    private List<Integer> validationAnswerNumbers(String number) {
        if(!isNumber(number)) throw new IllegalArgumentException("1부터 9까지의 3자리 수로 입력해주세요.");
        List<Integer> playerNumbers = new ArrayList<>();
        if(!isDuplicationNumber(number,playerNumbers)) throw new IllegalArgumentException("중복된 숫자를 입력하였습니다. 서로다른 3자리의 숫자로 입력해주세요.");

        return playerNumbers;
    }

    /* 입력값이 숫자인지 검증 */
    private boolean isNumber(String number) {
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    /* 숫자가 중복되어 있는지 검증 및 저장 */
    public boolean isDuplicationNumber(String number,List<Integer> playerNumbers) {
        for (char digit : number.toCharArray()) {
            int typeConversionDigit = Integer.parseInt(String.valueOf(digit));
            if(playerNumbers.contains(typeConversionDigit)) return false;
            playerNumbers.add(typeConversionDigit);
        }
        return true;
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }
}
