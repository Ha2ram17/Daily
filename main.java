package haeram;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hero[] 히어로 = {new Warrior("택", 100, 20),
						new Mage("법사", 100,20)};
		
		
		System.out.println("전사 : 1\n법사 : 2");
		int select = sc.nextInt();
	}
}