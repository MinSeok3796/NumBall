package NumBall04;

import java.util.*;

public class BaseBall {
    Scanner sc = new Scanner(System.in);
    private int digit = 3; //기본 자리수는 3자리로 실행
    private int inputNum = 0;
    private int answer = 0;
    private int count = 0;
    private ArrayList<Integer> counterList = new ArrayList<>();
    private String answerString;
    private boolean playtype = true;

    public BaseBall(){}

    public void setNum(int digit){ //난이도 설정 함수
        if( digit >= 3 && digit <= 5) {
            this.digit = digit; //입력받은 자리수로 자리수 초기화
            System.out.println(digit + "자리수 난이도로 설정되었습니다.");
        }else{
            System.out.println("자리수 설정은 3,4,5로 가능합니다.");
        }
    }


    public void makeRand(){ // 목표값 생성 함수
        answer = 0;
        Random rand = new Random();
        HashSet<Integer> answerSet = new HashSet<>();
        while(answerSet.size() < digit){
            int randNum = rand.nextInt(9)+1;
            answerSet.add(randNum);
        }
        int i = 1;
        for( int num : answerSet){
            answer = answer + num * i;
            i = i * 10;
        }
        System.out.println(answer);
    }


    public boolean play() throws Exception{
        System.out.println(" < 게임을 시작합니다 > ");
        count = 0;
        makeRand();
        do {
            System.out.println("숫자를 입력하세요");
            try {
                inputNum = sc.nextInt();
                if (Integer.toString(inputNum).length() != digit) {
                    System.out.println(digit + "자리 숫자를 입력해주세요");
                    continue;
                } else {
                    if(checkZeroDuplication()){

                    }else {
                        continue;
                    }
                }
            } catch (Exception e) {
                System.out.println("올바르지 못한 입력입니다.");
                sc.nextLine();
                continue;
            }
            playtype = checkAnswer();
            count++;

        }while(playtype);
        counterList.add(count);
        return false;
    }

    public boolean checkAnswer(){
        String mynum = Integer.toString(inputNum);
        answerString = Integer.toString(answer);
        int strike = 0;
        int ball = 0;
        for(int a = 0; a < digit; a++){
            for(int b = 0; b < digit; b++){
                if( a == b && mynum.charAt(a) == answerString.charAt(b)){
                    strike++;
                }else if( a != b && mynum.charAt(a) == answerString.charAt(b)){
                    ball++;
                }
            }
        }
        if(strike == digit){
            System.out.println("정답입니다.");
        }else if(strike == 0 && ball == 0) {
            System.out.println("아웃입니다.");
        }else{
            System.out.println(strike + "스트라이크 " + ball + "볼입니다.");
        }
        return inputNum != answer;
    }


    // 입력받은 숫자 0과 중복 확인
    public boolean checkZeroDuplication(){
        String inputNumStr = Integer.toString(inputNum);
        HashSet<Integer> myanswer = new HashSet<>();
        for( char c : inputNumStr.toCharArray()){
            myanswer.add(Character.getNumericValue(c));  //char형을 int형으로 바꿔주는 작업
        }
        if(myanswer.contains(0)){
            System.out.println("입력하신 숫자중에 0이 있습니다. 다시 입력해주세요");
            sc.nextLine();
            return false;
        }else if( myanswer.size() != digit){
            System.out.println("입력하신 숫자중에 중복이 있습니다. 다시 입력해주세요");
            sc.nextLine();
            return false;
        }
        return true;
    }


    public void history(){ //기록보기
        int playnumber = 1;
        if( counterList.isEmpty()){
            System.out.println("게임을 먼저 플레이 해주세요");
        }else{
            for( int i : counterList){
                System.out.println(playnumber + "번째 게임 : 시도횟수  -  " + i);
                playnumber++;
            }
        }
    }

    public void playNumError(){
        System.out.println("0~3번 사이의 옵션을 선택해주세요");
    }

}
