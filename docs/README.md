1. 컴퓨터는 1~9의 랜덤한 서로 다른 숫자 3자리를 받는다.

2. 게임 플레이어는 서로 다른 3개의 숫자를 입력한다.
   - 같은수 같은자리 일치 - 스트라이크
   - 다른 자리에 숫자 일치 - 볼
   - 전혀 불일치 - 낫싱
   - 
3. 결과에 대한 힌트를 출력한다.

4. 1~3 번을 반복하여 3개의 숫자를 모두 맞히면 종료

5. 게임이 끝난 후 재시작/ 종료를 구분하는 1과 2의 숫자 중 하나의 수를 입력 받는다.

* 데이터 유효성
1. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 종료
   - 입력값이 숫자가 아닌 값을 입력 할 경우
   - 입력값의 숫자가 중복될 경우
   - 입력값의 숫자가 3개 미만이거나 초과할 때