package designParkingLot.models;

import java.util.List;

import designParkingLot.models.enums.Status;

public class ParkingLot extends BaseModel {
	private String address;
	private List<ParkingFloor> parkingFloors;
	private List<Gate> gates;
	private Status status;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<ParkingFloor> getParkingFloors() {
		return parkingFloors;
	}
	public void setParkingFloors(List<ParkingFloor> parkingFloors) {
		this.parkingFloors = parkingFloors;
	}
	public List<Gate> getGates() {
		return gates;
	}
	public void setGates(List<Gate> gates) {
		this.gates = gates;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	

}
