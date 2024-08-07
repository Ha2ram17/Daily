package haeram;

import java.util.*;
import java.io.*;

public class Market {
	//static int 물건명번호;
	//int 물건번호 = ++물건명번호;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);
	String 판매물품상점명[] = new String[50]; //판매물품 상점명
	int 판매물품고유번호[] = new int[50]; //판매물품고유번호로 검색 시스템을 구현
	String 판매물품이름[] = new String[50]; //판매물품이름
	int 판매물품가격[] = new int[50];
	int 판매물품재고개수[] = new int[50]; //위 배열 네개와 두개와 인덱스를 공유하며, 고유번호에 대응되는 인덱스값으로 상품을 호출
	String 상점[] = new String[3]; //0번 인덱스에는 상점명, 1번 인덱스에는 상점소개문구 2번 인덱스에는 금고
	String 구매자[] = new String[3]; //0번 인덱스에는 닉네임, 1번 인덱스에는 돈, 2번 인덱스에는 돈
	String 장바구니[] = new String[15]; //장바구니의 한계는 15로 설정
	
	public String[] get상점() {
		return 상점;
	}

	public void set상점(String[] 상점) {
		this.상점 = 상점;
	}
	//-------------------------
	void 임시진행스탑() {
		System.out.println("아무 키를 입력하시면 메인 메뉴로 돌아갑니다.");
		String 임시 = sc.next();
	}
	//-------------------------
	void 구매자임시프로세스() {
		판매물품상점명[0] = "한결패밀리";
		판매물품고유번호[0] = 0;
		판매물품이름[0] = "G Pro X Superlight 2, Black";
		판매물품가격[0] = 200000;
		판매물품재고개수[0] = 3;
		//--
		판매물품상점명[1] = "한결패밀리";
		판매물품고유번호[1] = 1;
		판매물품이름[1] = "G Pro X Superlight 2, White";
		판매물품가격[1] = 200000;
		판매물품재고개수[1] = 1;
		//--
		판매물품상점명[2] = "한결패밀리";
		판매물품고유번호[2] = 2;
		판매물품이름[2] = "G Pro X Superlight 2, Pink";
		판매물품가격[2] = 200000;
		판매물품재고개수[2] = 2;
	}
	//-------------------------
	public int 널카운트(String[] arr) {
		  int count = 0;
		  for (String element : arr) {
		    if (element != null) {
		      count++;
		    }
		  }
		  return count;
		}
	
	void 첫번째구매자세팅() throws IOException {
		구매자임시프로세스();
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
			첫번째구매자돈세팅();
		}
		else {
			System.out.println("첫 접속이므로, 메인메뉴로 이동은 불가합니다.");
			첫번째구매자세팅(); //재귀함수
		}
	}
	
	void 구매자돈세팅() throws IOException {
		System.out.println("하이퍼페이를 얼마나 충전하시겠습니까?");
		int x= sc.nextInt(); //돈
		int 임시정수 = 0; //현재 보유중인 하이퍼페이 호출
		String 임시문자 = 구매자[1];
		if(x>=5000) {
			임시정수=Integer.parseInt(임시문자); //현재 금액을 불러옴 //오류나는 부분
			System.out.printf("정말 %s만큼 하이퍼페이를 충전하시겠습니까?",x);
			System.out.println();
			System.out.printf("예상 충전 후 금액 : %s",(x+임시정수));
			System.out.println();
			System.out.println("금액 충전 : 1\n금액 수정 : 2");
			System.out.println();
			int a= sc.nextInt();
			if(a==1) {
				임시정수 += x;
				구매자[1] = Integer.toString(임시정수);
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
		구매자[1] = "0";
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
		System.out.printf("현재 보유중인 하이퍼페이는 '%s'입니다!",구매자[1]);
		System.out.println();
		임시진행스탑();
		구매자메뉴(); // 메뉴 재귀 호출하기
	}
	
	void 하이퍼마켓상품보기() {
		System.out.println("현재 판매중인 물품을 출력합니다.");
		System.out.println("상품이름 / 가격 / 상품번호 형식");
		int nullcount = 널카운트(판매물품이름);
		for(int i=0; i<nullcount; i++) {
			System.out.println(판매물품이름[i]+" / "+판매물품가격[i]+" / "+판매물품고유번호[i]);
		}
		System.out.println("상세정보를 원하시는 물품의 상품번호를 입력해주세요.");
		int select = sc.nextInt();
		상품상세탭(select);
	}
	
	void 상품상세탭(int i) {
		System.out.printf("상점명 : %s",판매물품상점명[i]);
		System.out.println();
		System.out.printf("상품명 : %s",판매물품이름[i]);
		System.out.println();
		System.out.printf("가격 : %d",판매물품가격[i]);
		System.out.println();
		System.out.printf("재고개수 : %d",판매물품재고개수[i]);
		System.out.println();
		System.out.println("구매 : 1\n장바구니 추가 : 2\n취소 및 메인메뉴 : 3");
		int select = sc.nextInt();
		if(select==1) {
			//제품구매
		}
		else if(select==2) {
			int nullcount = 널카운트(장바구니) -1;
			
		}
	}
	
	void 구매자메뉴() throws IOException {
		System.out.println();
		System.out.println("하이퍼마켓에 오신 것을 환영합니다.");
		System.out.println("현재 하이퍼마켓 메뉴화면입니다.");
		System.out.println("1. 하이퍼마켓 상품보기\n2. 하이퍼페이 충전\n3. 하이퍼페이 조회\n4. 장바구니 확인하기");
		int select = sc.nextInt();
		if(select==1) {
			하이퍼마켓상품보기();
		}
		else if(select==2) {
			System.out.println("-하이퍼페이 충전 메뉴-");
			구매자돈세팅();
		}
		else if(select==3) {
			System.out.println("현재 보유중인 하이퍼페이를 조회합니다.");
			하이퍼페이조회(); 
		}
		else if(select==4) {
			System.out.println("하이퍼마켓의 장바구니를 조회합니다.");
			//장바구니조회() //미구현
		}
		else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            구매자메뉴(); // 재귀 호출하기
        }
	//-------------------------------------------------------------- UP 구매자 메소드
	//------------------------------------------------------------- DOWN 판매자 메소드
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
			임시진행스탑();
			System.out.println();
			판매자메뉴();
		}
		else {
			System.out.println("상점소개문구 수정을 중단하셨습니다. 메인으로 돌아갑니다.");
			임시진행스탑();
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
					임시진행스탑();
					판매자메뉴();
				}
				else {
					System.out.println("상점소개문구 : "+상점[1]);
					임시진행스탑();
					판매자메뉴();
				}
			}
			else {
	            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
	            임시진행스탑();
	            판매자메뉴(); // 재귀 호출하기
	        }
			
		}
		else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            임시진행스탑();
            판매자메뉴(); // 재귀 호출하기
        }
	}
		
	}
