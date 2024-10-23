package NumBall04;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in); //스캐너 객체 생성
        int playnum = 0;
        boolean play = true;
        BaseBall baseBall = new BaseBall();
        System.out.println("환영합니다. 원하시는 번호를 입력해주세요");
        do {
            System.out.println("0.자리수 설정  1.게임 시작하기  2.게임 기록보기  3.종료하기");

            try {
                playnum = sc.nextInt();
                switch (playnum) {
                    case 0: //자리수 설정
                        System.out.println("설정하고자 하는 자리수를 입력하세요");
                        int digit = sc.nextInt();
                        baseBall.setNum(digit);
                        break;
                    case 1: //게임 시작하기
                        play = !baseBall.play();
                        break;
                    case 2: //게임 기록보기
                        baseBall.history();
                        break;
                    case 3: //게임 종료
                        System.out.println(" < 숫자 야구 게임을 종료합니다 > ");
                        play = false;
                        break;
                    default: //0~3외 숫자 입력시 문구 출력
                        baseBall.playNumError();
                        break;
                }
            }catch(Exception e){
                System.out.println("숫자만 입력해주세요");
                sc.nextLine();
            }
        }while(play);
    }
}
