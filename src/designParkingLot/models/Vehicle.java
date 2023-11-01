package designParkingLot.models;

import designParkingLot.models.enums.VehicleType;

public class Vehicle extends BaseModel {
	private String vehicleNumber;
	private VehicleType type;
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}

}
