package NumBall03;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 값 입력을 위한 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        int mynum = 0;
        int playnum = 0;

        ArrayList<Integer> tryarr = new ArrayList<Integer>();
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
        do {
            System.out.println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");
            playnum = sc.nextInt();
            switch (playnum) {
                case 1:
                    BaseBall baseBall = new BaseBall();  //야구 게임 생성
                    System.out.println(" < 게임을 시작합니다 >");
                    int count = 0;
                    do {
                        try {
                            HashSet<Integer> hashSet = new HashSet<>(); // 입력값 체크
                            System.out.println("숫자를 입력하세요");
                            mynum = sc.nextInt();
                            if (mynum < 100 || mynum > 999) { //입력값이 3자리인지 확인
                                System.out.println("입력하신 숫자가 3자리인지 확인해주세요");
                                sc.nextLine();
                                continue;
                            } else {
                                // 각 자리수를 HashSet에 저장
                                hashSet.add(mynum / 100);
                                hashSet.add((mynum % 100) / 10);
                                hashSet.add((mynum % 100) % 10);

                                if (hashSet.contains(0)) { //입력값에 0이 있는경우
                                    System.out.println("입력하신 숫자중에 0이 있습니다. 다시입력해주세요");
                                    sc.nextLine();
                                    continue;
                                } else if (hashSet.size() != 3) { //입력값에 중복이 있는경우
                                    System.out.println("입력하신 숫자중에 중복이 있습니다. 다시입력해주세요");
                                    sc.nextLine();
                                    continue;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("올바르지 못한 입력입니다.");
                            sc.nextLine();
                            continue;
                        }
                        play = baseBall.play(mynum);
                        count++;
                    } while (play);
                    tryarr.add(count);
                    break;
                case 2:
                    if(tryarr.size() == 0) {
                        System.out.println("게임을 실행한 기록이 없습니다.");
                    }else {
                        for (int i = 0; i < tryarr.size(); i++) {
                            System.out.println(i + 1 + "번째 게임 : 시도횟수 - " + tryarr.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.println("종료합니다.");
                    return;
                default:
                    System.out.println("1,2,3번중에 하나로 골라주세요");
                    break;
            }
            play = true;
        }while(play);

    }
}
