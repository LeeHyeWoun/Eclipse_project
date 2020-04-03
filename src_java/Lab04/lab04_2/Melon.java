
public class Melon extends Food {
	//경작 농원
	private String info;
	
	//접근자
	public String getInfo() {return info;};
	
	//설정자
	public void setInfo(String info) {this.info=info;};
	
	//메소드
	public String toString() {return "멜론의 칼로리는 "+getCal()+"\n가격은"+getCost()+"\n중량은 "+getKg()+"\n경작 농원 정보는 "+getInfo();};
}
