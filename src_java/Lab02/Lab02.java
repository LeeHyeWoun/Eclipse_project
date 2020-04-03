
import java.util.Scanner; // Scanner 클래스 포함...입력을 위해

public class Lab02 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in); // Scanner클래스의 객체 input 동적 생성
		
		int [] number = new int [10]; //10개의 정수를 받을 배열
		int [] count = new int [10]; //1~10,11~20,...,91~100 10개의 범위 각각에 들어가는 정수의 개수를 입력할 배열
		
		//입력
		System.out.println("1에서 100까지의 정수 10개를 입력해 주세요.");
		for(int i = 0; i<number.length; i++) { //for문을 통해 10개의 정수를 입력받는다.
			System.out.printf("%d번째 정수 : ",i+1);
			number[i] = input.nextInt();
		}
		
		//계산
		for(int i = 0; i<number.length; i++) { //number배열요소를 차례대로 확인하기 위한 반복문 
			for(int j=0; j<count.length; j++) { //number[i]가 몇번째 범위에 속하는지 차례대로 확인하기 위한 반복문
				if ((int)((number[i]-1)/10) == j) {count[j]++;}
			}
		}
		
		//출력
		System.out.println(); //입력과 출력 사이 간격 조절
		for(int i=0; i<count.length; i++) {
			System.out.printf("%d~%d : ", i*10+1,(i+1)*10); //범위를 출력
			for(int j=0; j<count[i]; j++) { System.out.print('*'); } //for반복문으로 count 값만큼 '*'을 출력
			System.out.println();// 다음 줄로 넘어가기
		}
		
	}
}