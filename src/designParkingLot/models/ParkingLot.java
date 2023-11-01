package designParkingLot.models;

import java.util.List;

public class ParkingLot extends BaseModel {
	private String name;
	private String address;
	private List<ParkingSlot> slots;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<ParkingSlot> getSlots() {
		return slots;
	}
	public void setSlots(List<ParkingSlot> slots) {
		this.slots = slots;
	}

}
