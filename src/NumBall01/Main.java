package NumBall01;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 값 입력을 위한 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);
        BaseBall baseBall = new BaseBall();  //야구 게임 생성
        boolean play = true;

        int mynum = 0;
        System.out.println(" < 게임을 시작합니다 >");
        do {
            try {
                HashSet<Integer> hashSet = new HashSet<>(); // 입력값 체크
                System.out.println("숫자를 입력하세요");
                mynum = sc.nextInt();

                if(mynum < 100 || mynum > 999){
                    System.out.println("입력하신 숫자가 3자리인지 확인해주세요");
                    sc.nextLine();
                    continue;
                }
                else{
                    // 각 자리수를 HashSet에 저장
                    hashSet.add(mynum/100);
                    hashSet.add((mynum%100)/10);
                    hashSet.add((mynum%100)%10);

                    if(hashSet.contains(0)){
                        System.out.println("입력하신 숫자중에 0이 있습니다. 다시입력해주세요");
                        sc.nextLine();
                        continue;
                    }else if(hashSet.size() != 3){
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
            if(play == false){
                System.out.println("정답입니다!");
            }
        }while(play);

    }
}
