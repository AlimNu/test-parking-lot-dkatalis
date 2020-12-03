package parking.lot.model;

public class Car {
	
	private String regNo;
	private Integer duration;
	public Car(String regNo, Integer duration) {
		super();
		this.regNo = regNo;
		this.duration = duration;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
