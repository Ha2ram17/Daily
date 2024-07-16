package haeram;

public interface Finggerprint {
	//필드는 무조건 상수(final)를 가져야한다.
	String 지문정보 = "엄지";
	
	static void 지문인식(Smart_phone 폰,String 지문) {
		if(지문정보.equals(지문)) {
			System.out.println("잠금이 해제되었습니다.");
		} else {
			폰.전원끄기();
		}
		
	}
	
}
