package haeram;

public class Mage extends Hero {
	int 마나;
	public Mage(String 이름, int 체력, int 공격력) {
		super(이름, 체력, 공격력);
		마나=20;
	}
	@Override
	void 자기소개() {
		System.out.printf("마법사 %s의 정보, 체력:%2d, 공격력:%2d, 마나:%2d \n",
				이름, 체력, 공격력, 마나);
	}
	@Override
	void 공격(Monster 적) {
		super.공격(적);
		마나+=10;
		System.out.printf("현재 마나는 %2d 입니다.\n", 마나);
	}
	
	void 명상() {
		
		마나+=20;
		System.out.println("🏔 ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰");
		System.out.println("　⛰　⛰　⛰　⛰　⛰　⛰　⛰　⛰ ⛰ ⛰ ⛰");
		System.out.println("스킬 '명상'을 시전합니다.");
		System.out.println("'명상' 스킬의 효과로 마나가 20 상승하였습니다.");
		System.out.printf("현재 마나는 %2d입니다!",마나);
		System.out.println();
		System.out.println("🏔 ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰ ⛰");
		System.out.println("　⛰　⛰　⛰　⛰　⛰　⛰　⛰　⛰ ⛰ ⛰ ⛰");
		System.out.println();
	}
	
	void 라이트닝(Monster 적) {
		if(마나>=60) {
			마나-=60;
			System.out.println("조건이 충족되었습니다.");
			System.out.printf("%s가, 스킬 '라이트닝'을 시전합니다.",이름);
			System.out.println();
			자기소개();
			적.자기소개();
			System.err.println("⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡");
			System.err.println("　⚡　⚡　⚡　⚡　⚡　⚡　⚡　⚡ ⚡ ⚡　");
			System.err.printf("%s가 %s에게 시전한 스킬 '라이트닝'이 명중했습니다.", 이름, 적.get이름());
			System.out.println();
			int 데미지 = 적.get체력()-(120);
			적.set체력(데미지);	
			System.err.printf("%s의 체력: %2d\n", 적.get이름(), 적.get체력());
			System.err.println("⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡");
			System.err.println("　⚡　⚡　⚡　⚡　⚡　⚡　⚡　⚡ ⚡ ⚡　");
		}
		else {
			System.out.println("마나가 부족하여 스킬 시전에 실패하였습니다.");
		}
	}
}
