package designParkingLot.repository;

import java.util.HashMap;
import java.util.Map;

import designParkingLot.exception.ParkingSpotNotFoundException;
import designParkingLot.models.ParkingSpot;

public class ParkingSpotRepository {
	private Map<Integer, ParkingSpot> parkingSpotMap;

	public ParkingSpotRepository() {
		super();
		this.parkingSpotMap = new HashMap<Integer, ParkingSpot>();
	}
	
	public ParkingSpot get(int ParkingSpotId) {
		ParkingSpot parkingSpot = parkingSpotMap.get(ParkingSpotId);
		if(parkingSpot == null) {
			throw new ParkingSpotNotFoundException("Parking spot not found with id: " + ParkingSpotId);
		}
		return parkingSpot;
	}
	
	public void put(ParkingSpot ParkingSpot) {
		parkingSpotMap.put(ParkingSpot.getId(), ParkingSpot);
		System.out.println("Parking spot added successfully with spot Id: " + ParkingSpot.getId());
	}

}
