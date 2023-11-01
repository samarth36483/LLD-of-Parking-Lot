package designParkingLot.models;

import designParkingLot.models.enums.ParkingSlotStatus;
import designParkingLot.models.enums.VehicleType;

public class ParkingSlot extends BaseModel {
	private String boothNumber;
	private ParkingSlotStatus status;
	private VehicleType type;
	private ParkingLot parkingLot;
	
	public String getBoothNumber() {
		return boothNumber;
	}
	public void setBoothNumber(String boothNumber) {
		this.boothNumber = boothNumber;
	}
	public ParkingSlotStatus getStatus() {
		return status;
	}
	public void setStatus(ParkingSlotStatus status) {
		this.status = status;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public ParkingLot getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

}
