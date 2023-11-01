package designParkingLot.models;

import java.util.Date;

public class Operator extends BaseModel {
	private String name;
	private String username;
	private String password;
	private Date shiftStart;
	private Date shiftEnd;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getShiftStart() {
		return shiftStart;
	}
	public void setShiftStart(Date shiftStart) {
		this.shiftStart = shiftStart;
	}
	public Date getShiftEnd() {
		return shiftEnd;
	}
	public void setShiftEnd(Date shiftEnd) {
		this.shiftEnd = shiftEnd;
	}

}
