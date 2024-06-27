package haeram;

import java.util.*;
import java.io.*;

public class Market {
	//static int 물건명번호;
	//int 물건번호 = ++물건명번호;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);
	String 판매물품[] = new String[3]; //0번 인덱스에는 상품고유번호, 1번 판매가격, 2번 재고개수
	String 상점[] = new String[3]; //0번 인덱스에는 상점명, 1번 인덱스에는 상점소개문구 2번 인덱스에는 금고
	String 구매자[] = new String[3]; //0번 인덱스에는 닉네임, 1번 인덱스에는 돈, 2번 인덱스에는 돈
	String 장바구니[] = new String[15]; //장바구니의 한계는 15로 설정
	
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
	
	void 첫번째구매자세팅() throws IOException {
		System.out.println("하이퍼마켓에 오신 것을 환영합니다.");
		System.out.println("첫 접속이므로, 닉네임을 설정해주세요.");
		System.out.println("정하실 닉네임을 입력해주세요.");
		String buyname= in.readLine(); //임시닉네임 
		System.out.printf("정말 '%s'로 정하시겠습니까? 한번 정하신 닉네임은 다시 바꿀 수 없습니다.",buyname);
		System.out.println("");
		System.out.println("확정하시려면 1번, 그만두시려면 2번을 눌러주세요.");
		int select = sc.nextInt();
		if(select==1) {
			구매자[0]=buyname;
			System.out.println("닉네임 설정이 완료되었습니다.");
			System.out.printf("현재 닉네임은 '%s'입니다!",구매자[0]);
			System.out.println();
			System.out.println("첫 접속이므로, 하이퍼페이를 충전합니다. 최소 충전치는 5000입니다.");
			구매자돈세팅();
		}
		else {
			System.out.println("첫 접속이므로, 메인메뉴로 이동은 불가합니다.");
			첫번째구매자세팅(); //재귀함수
		}
	}
	
	void 구매자돈세팅() throws IOException {
		System.out.println("하이퍼페이를 얼마나 충전하시겠습니까?");
		int x= sc.nextInt(); //돈
		int 임시 = 0; //현재 보유중인 하이퍼페이 호출
		if(x>=5000) {
			임시=Integer.parseInt(구매자[1]); //현재 금액을 불러옴 //오류나는 부분
			System.out.printf("정말 %s만큼 하이퍼페이를 충전하시겠습니까?",x);
			System.out.println();
			System.out.printf("예상 충전 후 금액 : %s",(x+임시));
			System.out.println();
			System.out.println("금액 충전 : 1\n금액 수정 : 2");
			System.out.println();
			int a= sc.nextInt();
			if(a==1) {
				임시 += x;
				구매자[1] = Integer.toString(임시);
				System.out.printf("예상 충전 후 금액 : %s",구매자[1]);
				구매자메뉴();
			}
		}
		else {
			System.out.println("최소 충전 금액은 '5000'입니다!");
			구매자돈세팅();
		}
		
	}
	
	void 첫번째구매자돈세팅() throws IOException {
		System.out.println("하이퍼페이를 얼마나 충전하시겠습니까?");
		int x= sc.nextInt(); //돈
		if(x>=5000) {
			System.out.printf("정말 %s만큼 하이퍼페이를 충전하시겠습니까?",x);
			System.out.println();
			System.out.printf("예상 충전 후 금액 : %s",x);
			System.out.println();
			System.out.println("금액 충전 : 1\n금액 수정 : 2");
			System.out.println();
			int a= sc.nextInt();
			if(a==1) {
				구매자[1] = Integer.toString(x);
				System.out.printf("예상 충전 후 금액 : %s",구매자[1]);
				구매자메뉴();
			}
		}
		else {
			System.out.println("최소 충전 금액은 '5000'입니다!");
			구매자돈세팅();
		}
		
	}

	void 하이퍼페이조회() throws IOException {
		System.out.println(상점[1]);
		구매자메뉴();
	}
	
	void 구매자메뉴() throws IOException {
		System.out.println();
		System.out.println("하이퍼마켓에 오신 것을 환영합니다.");
		System.out.println("현재 하이퍼마켓 메뉴화면입니다.");
		System.out.println("1. 하이퍼마켓 상품보기\n2. 하이퍼페이 충전\n3. 하이퍼페이 조회");
		int select = sc.nextInt();
		if(select==1) {
			System.out.println("구매하고싶으신 물품의 번호를 입력해주세요.");
		}
		else if(select==2) {
			System.out.println("-하이퍼페이 충전-");
			구매자돈세팅();
		}
		else if(select==3) {
			System.out.println("현재 보유중인 하이퍼페이를 조회합니다.");
			select = sc.nextInt();
			if(select==1) {
				하이퍼페이조회();
			}
			else {
	            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
	            구매자메뉴(); // 재귀 호출하기
	        }
			
		}
		else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            구매자메뉴(); // 재귀 호출하기
        }
		
	}
	void 첫번째상점명세팅() throws IOException {
		System.out.println("하이퍼마켓에 오신 것을 환영합니다.");
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
		System.out.println("현재 하이퍼마켓 메뉴화면입니다.");
		System.out.println("1. 하이퍼마켓 판매물품 등록\n2. 하이퍼마켓 재고관리\n3. 하이퍼마켓 상점 관리");
		int select = sc.nextInt();
		if(select==1) {
			System.out.println("등록할 판매물품의 이름을 입력해주세요.");
		}
		else if(select==2) {
			System.out.println("관리할 재고의 고유물품번호를 입력해주세요.");
		}
		else if(select==3) {
			System.out.println("1. 하이퍼마켓 상점명 수정\n2. 하이퍼마켓 상점소개문구 수정\n3. 현재 상점명과 상점소개문구 조회.");
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
