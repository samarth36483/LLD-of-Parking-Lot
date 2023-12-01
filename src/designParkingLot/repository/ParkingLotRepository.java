package designParkingLot.repository;

import java.util.HashMap;
import java.util.Map;

import designParkingLot.exception.ParkingLotNotFoundException;
import designParkingLot.models.Gate;
import designParkingLot.models.ParkingLot;

public class ParkingLotRepository {
	private Map<Integer, ParkingLot> parkingLotMap;

	public ParkingLotRepository() {
		super();
		this.parkingLotMap = new HashMap<>();
	}
	
	public ParkingLot get(int ParkingLotId) {
		ParkingLot parkingLot = parkingLotMap.get(ParkingLotId);
		if(parkingLot == null) {
			throw new ParkingLotNotFoundException("Parking Lot not found with id: " + ParkingLotId);
		}
		return parkingLot;
	}
	
	public void put(ParkingLot parkingLot) {
		parkingLotMap.put(parkingLot.getId(), parkingLot);
		System.out.println("Parking lot added successfully with Parking Lot Id: " + parkingLot.getId());
	}
	
	public ParkingLot getParkingLotFromGate(Gate gate) {
		int parkingLotId = gate.getParkingLotId();
		ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
		if(parkingLot == null) {
			throw new ParkingLotNotFoundException("Parking Lot not found with gate: " + gate.getId());
		}
		return parkingLot;
	}

}
