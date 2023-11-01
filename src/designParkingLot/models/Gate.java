package designParkingLot.models;

import designParkingLot.models.enums.GateType;

public class Gate extends BaseModel {
	private String gateNumber;
	private ParkingLot parkingLot;
	private GateType type;
	private Operator currentOperator;
	
	public String getGateNumber() {
		return gateNumber;
	}
	public void setGateNumber(String gateNumber) {
		this.gateNumber = gateNumber;
	}
	public ParkingLot getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	public GateType getType() {
		return type;
	}
	public void setType(GateType type) {
		this.type = type;
	}
	public Operator getOperator() {
		return currentOperator;
	}
	public void setOperator(Operator operator) {
		this.currentOperator = operator;
	}

}
