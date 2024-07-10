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
	void 상품혹은메뉴() throws IOException {
		System.out.println("하이퍼마켓 상품보기 : 1\n메인 메뉴 : 2");
		int 임시 = sc.nextInt();
		if(임시==1) {
			하이퍼마켓상품보기();
		}
		else if(임시==2) {
			구매자메뉴();
		}
		else {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			상품혹은메뉴();
		}
	}
	//-------------------------
	void 임시진행스탑() {
		System.out.println("아무 키를 입력하시면 메인 메뉴로 돌아갑니다.");
		String 임시 = sc.next();
	}
	//-------------------------
	void 상품이름확인절차(String i) throws IOException {
		System.out.printf("상품 가격을 '%s'로 결정하시겠습니까?\n확인 : 1\n취소 : 2",i);
		String 임시 = sc.next();
		if("1".equals(임시)) {
			System.out.println("확인되었습니다.");
		}
		else {
			System.out.println("취소하셨습니다.");
			판매물품등록();
		}
		
	}
	
	void 상품가격확인절차(String i) throws IOException {
		System.out.printf("상품 가격을 '%s'로 결정하시겠습니까?\n확인 : 1\n취소 : 2",i);
		String 임시 = sc.next();
		if("1".equals(임시)) {
			System.out.println("확인되었습니다.");
		}
		else {
			판매물품등록();
		}
		
	}
	void 상품재고확인절차(String i) throws IOException {
		System.out.printf("상품 가격을 '%s'로 결정하시겠습니까?\n확인 : 1\n취소 : 2",i);
		String 임시 = sc.next();
		if("1".equals(임시)) {
			System.out.println("확인되었습니다.");
		}
		else {
			판매물품등록();
		}
		
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
		//--
		장바구니[0]="0709";
	}
	//-------------------------
	public int 널카운트(String[] array) { //forEach문
		  int count = 0;
		  for (String element : array) {
		    if (element != null) {
		      count++;
		    }
		  }
		  return count;
		}
	public int 고유번호추출널카운트(int[] array) { //forEach문
		  int count = 0;
		  for (int element : array) {
		    if (element != 0) {
		      count++;
		    }
		  }
		  count++;
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
			System.out.println("------------------------");
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
	
	void 구매프로세스(int i, int a) throws IOException {
		구매자[1] = Integer.toString(a);
		판매물품재고개수[i] = -1;
		System.out.printf("'%s'상품의 구매가 완료되었습니다!",판매물품이름[i]);
		System.out.println();
		System.out.println("주문 내역에서 확인이 가능합니다.");
		임시진행스탑();
		구매자메뉴();
	}
	
	void 하이퍼마켓상품구매(int i) throws IOException {
		int a = Integer.parseInt(구매자[1]);
		a -= 판매물품가격[i];
		System.out.println("------------------------");
		System.out.printf("상품명 : %s",판매물품이름[i]);
		System.out.println();
		System.out.printf("가격 : %d",판매물품가격[i]);
		System.out.println();
		System.out.printf("보유중인 하이퍼페이 : %s",구매자[1]);
		System.out.println();
		System.out.println("------------------------");
		if(a>0) {
			System.out.printf("구매 후 잔액 : %d",a);
			System.out.println();
			System.out.println("정말로 구매하시겠습니까?\n구매 : 1\n취소 : 2");
			int 임시 = sc.nextInt();
			if(임시==1) {
				구매프로세스(i,a);
			}
			else if(임시==2) {
				구매자메뉴();
			}
			else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				상품혹은메뉴();
			}
		}
		else {
			 System.out.println("현재 보유중인 하이퍼페이로는 구입이 불가합니다.");
			 상품혹은메뉴();
		}
	}
	void 하이퍼마켓상품보기() throws IOException {
		System.out.println("현재 판매중인 물품을 출력합니다.");
		System.out.println("형식 : 상품이름 / 가격 / 상품번호");
		int nullcount = 널카운트(판매물품이름);
		for(int i=0; i<nullcount; i++) {
			System.out.println(판매물품이름[i]+" / "+판매물품가격[i]+" / "+판매물품고유번호[i]);
		}
		System.out.println("------------------------");
		System.out.println("상세정보를 원하시는 물품의 상품번호를 입력해주세요.");
		int select = sc.nextInt();
		상품상세탭(select);
	}
	
	void 장바구니추가(int i) {
		String passkey = "7079";
		if(passkey.equals(장바구니[0])) {
			int nullcount = 널카운트(장바구니)-1;
			장바구니[nullcount]=Integer.toString(판매물품고유번호[i]);
			System.out.println("장바구니에 추가되었습니다.");
			System.out.printf("'%s'상품이 장바구니에 추가 완료되었습니다!",판매물품이름[i]);
			System.out.println();
			System.out.println("주문 내역에서 확인이 가능합니다.");
		}
		else {
			int nullcount = 널카운트(장바구니);
			장바구니[nullcount]=Integer.toString(판매물품고유번호[i]);
			System.out.println("장바구니에 추가되었습니다.");
			System.out.printf("'%s'상품이 장바구니에 추가 완료되었습니다!",판매물품이름[i]);
			System.out.println();
			System.out.println("주문 내역에서 확인이 가능합니다.");
		}
	}
	
	void 상품상세탭(int i) throws IOException {
		System.out.printf("상점명 : %s",판매물품상점명[i]);
		System.out.println();
		System.out.printf("상품명 : %s",판매물품이름[i]);
		System.out.println();
		System.out.printf("가격 : %d",판매물품가격[i]);
		System.out.println();
		if(판매물품재고개수[i]<0) {
			System.out.println("재고개수 : 품절");
		}
		else {
			System.out.printf("재고개수 : %d",판매물품재고개수[i]);
			System.out.println();
		}
		System.out.println("------------------------");
		System.out.println("구매 : 1\n장바구니 추가 : 2\n취소 및 메인메뉴 : 3");
		int select = sc.nextInt();
		if(select==1) {
			if(판매물품재고개수[i]>0) {
				하이퍼마켓상품구매(i);
			}
			else {
				System.out.println("현재 해당 상품의 재고가 부족하여 구매가 불가합니다.");
				상품혹은메뉴();
			}
		}
		else if(select==2) {
			장바구니추가(i);
			임시진행스탑();
			구매자메뉴();
		}
		else if(select==3) {
			System.out.println("취소되었습니다.");
			상품혹은메뉴();
		}
	}
	
	void 장바구니조회() throws IOException {
		System.out.println("현재 장바구니의 물품을 출력합니다.");
		System.out.println("형식 : 상품이름 / 가격 / 상품번호");
		int nullcount = 널카운트(장바구니)-1;
		int count = 0;
		for(int i=0; i<nullcount; i++) {
			System.out.println(판매물품이름[i]+" / "+판매물품가격[i]+" / "+판매물품고유번호[i]);
			count++;
		}
		System.out.println("------------------------");
		System.out.println("상세정보를 원하시는 물품의 상품번호를 입력해주세요.");
		if(count==0) {
			System.out.println("장바구니에 상품이 존재하지 않습니다.");
			임시진행스탑();
		}
		else {
			int select = sc.nextInt();
			상품상세탭(select);
		}
	}
	void 구매자메뉴() throws IOException {
		System.out.println();
		System.out.println("하이퍼마켓에 오신 것을 환영합니다.");
		System.out.println("현재 하이퍼마켓 메뉴화면입니다.");
		System.out.println("------------------------");
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
			장바구니조회();
		}
		else if(select==5) {
			판매물품등록();
		}
		else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            구매자메뉴(); // 재귀 호출하기
        }
	//-------------------------------------------------------------- UP 구매자 메소드
	//------------------------------------------------------------- DOWN 판매자 메소드
	}
	void 첫번째상점명세팅() throws IOException {
		구매자임시프로세스();
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
	
	void 판매물품등록() throws IOException {
		int indexselect = 고유번호추출널카운트(판매물품고유번호);
		System.out.println("판매하실 물품의 이름을 입력해주세요.");
		String 상품이름 = in.readLine();
		상품이름확인절차(상품이름);
		판매물품이름[indexselect]=상품이름;
		System.out.println("물품의 판매하실 가격을 입력해주세요.");
		String 상품가격 = in.readLine();
		상품가격확인절차(상품가격);
		판매물품가격[indexselect]=Integer.parseInt(상품가격);
		System.out.println("물품의 재고 개수를 입력해주세요.");
		String 상품재고 = in.readLine();
		상품재고확인절차(상품재고);
		판매물품재고개수[indexselect]=Integer.parseInt(상품재고);
		판매물품상점명[indexselect] = 상점[0];
		판매자메뉴(); //판매물품 출력시 문제가 생김. 수정할 것.
		}
	
	void 판매자메뉴() throws IOException {
		int pan;
		System.out.println();
		System.out.println("현재 하이퍼마켓 메뉴화면입니다.");
		System.out.println("1. 하이퍼마켓 판매물품 등록\n2. 하이퍼마켓 재고관리\n3. 하이퍼마켓 상점 관리");
		int select = sc.nextInt();
		if(select==1) {
			판매물품등록();
		}
		else if(select==2) {
			System.out.println("관리할 재고의 고유물품번호를 입력해주세요.");
			//미구현
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
		else if(select==9) {
				System.out.println("구매자메뉴로 전환합니다.");
				첫번째구매자세팅();
		}
		else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            임시진행스탑();
            판매자메뉴(); // 재귀 호출하기
        }
	}
		
	}
