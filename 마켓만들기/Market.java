package haeram;

import java.util.*;

public class Market {
	static int 물건명번호;
	int 물건번호 = ++물건명번호;
	Scanner sc = new Scanner(System.in);
	String 판매물품;
	int 판매가격;
	int 재고개수;
	
	public String get판매물품() {
		return 판매물품;
	}

	public void set판매물품(String 판매물품) {
		this.판매물품 = 판매물품;
	}

	public int get판매가격() {
		return 판매가격;
	}

	public void set판매가격(int 판매가격) {
		this.판매가격 = 판매가격;
	}

	public int get재고개수() {
		return 재고개수;
	}

	public void set재고개수(int 재고개수) {
		this.재고개수 = 재고개수;
	}
	
	public Market(String 판매물품, int 판매가격,int 재고개수) {
		this.판매물품=판매물품;
		this.판매가격=판매가격;
		this.재고개수=재고개수;
	}
	
	void 판매자메뉴() {
		int pan;
		System.out.println("1. 판매물품 등록\n2. 재고관리\n3. 상점소개문구 수정");
		int select = sc.nextInt();
		if(select==1) {
		}
		else if(select==2) {
			
		}
		else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            판매자메뉴(); // 재귀 호출하기
        }
	}
		
	}
