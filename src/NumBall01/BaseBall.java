package NumBall01;

import java.util.HashSet;

public class BaseBall {
    private int answer;
    private String answerString;

    // 생성자에 의해 생성될때 랜덤함수를 이용하여 정답 생성
    public BaseBall() {
        int hundred = (int) (Math.random() * 9) + 1;
        int ten;
        int one;
        do {
            ten = (int) (Math.random() * 9) + 1;
        } while (ten == hundred);

        do {
            one = (int) (Math.random() * 9) + 1;
        } while (one == hundred || one == ten);
        this.answer = hundred * 100 + ten * 10 + one;
        System.out.println(answer);
    }
    //게임의 진행 부분
    public boolean play(int num){
        String mynum = Integer.toString(num);
        answerString = Integer.toString(this.answer);
        int strike = 0;
        int ball = 0;
        for(int a = 0; a < 3; a++){
            for(int b = 0; b < 3; b++){
                if( a == b && mynum.charAt(a) == answerString.charAt(b)){
                    strike++;
                }else if( a != b && mynum.charAt(a) == answerString.charAt(b)){
                    ball++;
                }
            }
        }
        if(strike == 3){
            System.out.println("아웃입니다.");
        }else {
            System.out.println(strike + "스트라이크 " + ball + "볼입니다.");
        }
        return num != answer;
    }

}
