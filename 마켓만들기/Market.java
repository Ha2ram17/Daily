package haeram;

import java.util.*;
import java.io.*;

public class Market {
	//static int 물건명번호;
	//int 물건번호 = ++물건명번호;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);
	String 판매물품[] = new String[3]; //0번 인덱스에는 상품고유번호, 1번 판매가격, 2번 재고개수
	String 상점[] = new String[2]; //0번 인덱스에는 상점명, 1번 인덱스에는 상점소개문구
	
	public String[] get판매물품() {
		return 판매물품;
	}

	public void set판매물품(String[] 판매물품) {
		this.판매물품 = 판매물품;
	}

	public String[] get상점() {
		return 상점;
	}

	public void set상점(String[] 상점) {
		this.상점 = 상점;
	}
	

	void 첫번째상점명세팅() throws IOException {
		System.out.println("첫 접속이므로, 상점명을 입력해주세요.");
		System.out.println("정하실 상점명을 입력해주세요.");
		String sangname= in.readLine(); //임시상점이름 
		System.out.printf("정말 '%s'로 정하시겠습니까?",sangname);
		System.out.println("");
		System.out.println("확정하시려면 1번, 그만두시려면 2번을 눌러주세요.");
		int select = sc.nextInt();
		if(select==1) {
			상점[0]=sangname;
			System.out.println("상점명 설정이 완료되었습니다.");
			System.out.printf("현재 상점명은 '%s'입니다!",상점[0]);
			System.out.println();
			판매자메뉴();
		}
		else {
			System.out.println("첫 접속이므로, 메인메뉴로 이동은 불가합니다.");
			상점명세팅();
		}
	}
	
	void 상점명세팅() throws IOException {
		System.out.println("수정하실 상점명을 입력해주세요.");
		String sangname= in.readLine(); //임시상점이름
		System.out.printf("정말 '%s'로 수정하시겠습니까?",sangname);
		System.out.println("");
		System.out.println("확정하시려면 1번, 그만두시려면 2번을 눌러주세요.");
		int select = sc.nextInt();
		if(select==1) {
			상점[0]=sangname;
			System.out.println("상점명 수정이 완료되었습니다.");
			System.out.printf("현재 상점명은 '%s'입니다!",상점[0]);
			System.out.println();
			판매자메뉴();
		}
		else {
			System.out.println("상점명 수정을 중단하셨습니다. 메인으로 돌아갑니다.");
			판매자메뉴();
		}
	}
	void 상점소개문구세팅() throws IOException {
		System.out.println("수정하실 상점소개문구를 입력해주세요.");
		String sangname= in.readLine(); //임시상점이름
		System.out.printf("정말 '%s'로 수정하시겠습니까?",sangname);
		System.out.println("");
		System.out.println("수정하시려면 1번, 그만두시려면 2번을 눌러주세요.");
		int select = sc.nextInt();
		if(select==1) {
			상점[1]=sangname;
			System.out.println("상점소개문구 수정이 완료되었습니다.");
			System.out.printf("현재 상점소개문구는 '%s'입니다!",상점[1]);
			System.out.println();
			판매자메뉴();
		}
		else {
			System.out.println("상점소개문구 수정을 중단하셨습니다. 메인으로 돌아갑니다.");
			판매자메뉴();
		}
	}
	
	void 판매자메뉴() throws IOException {
		int pan;
		System.out.println();
		System.out.println("1. 판매물품 등록\n2. 재고관리\n3. 상점관리설정");
		int select = sc.nextInt();
		if(select==1) {
			System.out.println("등록할 판매물품의 이름을 입력해주세요.");
		}
		else if(select==2) {
			System.out.println("관리할 재고의 고유물품번호를 입력해주세요.");
		}
		else if(select==3) {
			System.out.println("상점명을 수정하시려면 1번, 상점소개문구를 수정하시려면 2번, 현재 상점명과 상점소개문구를 확인하려면 3을 눌러주세요.");
			select = sc.nextInt();
			if(select==1) {
				상점명세팅();
			}
			else if(select==2) {
				상점소개문구세팅();
			}
			else if(select==3) {
				System.out.println("상점명 : "+상점[0]);
				if(상점[1]==null) {
					System.out.println("상점소개문구 : 미정");
				}
				else {
					System.out.println("상점소개문구 : "+상점[1]);
				}
			}
			else {
	            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
	            판매자메뉴(); // 재귀 호출하기
	        }
			
		}
		else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            판매자메뉴(); // 재귀 호출하기
        }
	}
		
	}
