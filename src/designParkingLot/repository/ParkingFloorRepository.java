package designParkingLot.repository;

import java.util.HashMap;
import java.util.Map;

import designParkingLot.exception.ParkingFloorNotFoundException;
import designParkingLot.models.ParkingFloor;

public class ParkingFloorRepository {
	private Map<Integer, ParkingFloor> parkingFloorMap;

	public ParkingFloorRepository() {
		super();
		this.parkingFloorMap = new HashMap<Integer, ParkingFloor>();
	}
	
	public ParkingFloor get(int ParkingFloorId) {
		ParkingFloor parkingFloor = parkingFloorMap.get(ParkingFloorId);
		if(parkingFloor == null) {
			throw new ParkingFloorNotFoundException("Parking floor not found with id: " + ParkingFloorId);
		}
		return parkingFloor;
	}
	
	public void put(ParkingFloor parkingFloor) {
		parkingFloorMap.put(parkingFloor.getId(), parkingFloor);
		System.out.println("Parking floor added successfully with Parking floor Id: " + parkingFloor.getId());
	}

}
