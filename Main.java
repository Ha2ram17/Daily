package haeram;

public class Main {

	public static void main(String[] args) {
		Smart_phone[] 폰가방 = {
				new iPhone("아이폰 14", "블랙",50,"한결얼굴"),
				new Galaxy("갤럭시 21","실버",50,"한결카드")
		};
		
		for(Smart_phone s : 폰가방) {
			s.자기소개();
			s.전원켜기();
			s.set볼륨(100);
			System.out.println();
		}
		
	}

}
