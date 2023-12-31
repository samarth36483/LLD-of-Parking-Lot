package designParkingLot.models;

import java.time.LocalDateTime;

public class Token extends BaseModel {
	private LocalDateTime entryTime;
	private Vehicle vehicle;
	private ParkingSpot parkingSpot;
	
	public LocalDateTime getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	@Override
	public String toString() {
		return "Token -> entryTime = " + entryTime + ", " + vehicle.toString() + ", " + parkingSpot.toString();
	}
	
}
