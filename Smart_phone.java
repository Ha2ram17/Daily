package haeram;

public abstract class Smart_phone {
	String 모델명;
	String 색상;
	int 볼륨;
	
	public Smart_phone(String 모델명, String 색상, int 볼륨) {
		this.모델명 = 모델명;
		this.색상 = 색상;
		this.볼륨 = 볼륨;
	}
	
	void 자기소개() {
		System.out.printf("모델명: %s, 색상: %s, 볼륨:%d",모델명,색상,볼륨);
		System.out.println();
	}
	
	abstract void 전원켜기();
	abstract void 전원끄기();
	abstract void set볼륨(int 볼륨);
	
}
