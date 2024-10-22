package NumBall01;

import java.util.HashSet;

public class BaseBall {
    private int answer;

    private HashSet<Integer> correctSet = new HashSet<Integer>();
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
        correctSet.add(hundred);
        correctSet.add(ten);
        correctSet.add(one);
    }
    //게임의 진행 부분
    public boolean play(int num){
        return num != answer;
    }

}
