package designParkingLot.models;

import java.util.Date;

public class Ticket extends BaseModel {
	private Vehicle vehicle;
	private ParkingSlot slot;
	private Gate gate;
	private Operator operator;
	private Date entryTime;
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public ParkingSlot getSlot() {
		return slot;
	}
	public void setSlot(ParkingSlot slot) {
		this.slot = slot;
	}
	public Gate getGate() {
		return gate;
	}
	public void setGate(Gate gate) {
		this.gate = gate;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

}
