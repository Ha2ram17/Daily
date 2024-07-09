package haeram;

import java.util.*;
import java.io.*;

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
	            System.out.println();
	            return selectMode(sc); // 재귀 호출
	        }
	    }
	public static void main(String[] args) throws IOException {
		Market m1= new Market();
		Scanner sc = new Scanner(System.in);
		boolean Clint;
		Clint=selectMode(sc);
		if(Clint==false) {
			m1.첫번째상점명세팅();
			m1.판매자메뉴();
		}
		else if(Clint==true) {
			m1.첫번째구매자세팅();
			m1.구매자메뉴();
		}
		
	}

}
