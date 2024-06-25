package haeram;

import java.util.*;

public class main {

	 public static boolean selectMode(Scanner sc) {
	        System.out.println("행동을 선택해주세요.");
	        System.out.println("1. 구매자\n2. 판매자");
	        int choice = sc.nextInt();

	        if (choice == 1) {
	            System.out.println("구매자 전용 모드로 구동합니다.");
	            return true;
	        } else if (choice == 2) {
	            System.out.println("판매자 전용 모드로 구동합니다.");
	            return false;
	        } else {
	            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
	            return selectMode(sc); // 재귀 호출
	        }
	    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean Clint;
		Market m1 = new Market("사과",1450,30);
		Clint=selectMode(sc);
		if(Clint==false) {
			//System.out.println("1. 판매물품 등록\n2. 재고관리\n3. 상점소개문구 수정");
			//위를 메소드화
		}
		else if(Clint==true) {
			//System.out.println("1. 상품목록 열기\n2. 마켓머니 확인\n3. 네고요청 확인");
			//위를 메소드화
		}
		
	}

}