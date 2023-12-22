package designParkingLot.service;

import java.util.ArrayList;
import java.util.List;

import designParkingLot.models.Gate;
import designParkingLot.models.ParkingFloor;
import designParkingLot.models.ParkingLot;
import designParkingLot.models.ParkingSpot;
import designParkingLot.models.enums.GateType;
import designParkingLot.models.enums.Status;
import designParkingLot.models.enums.VehicleType;
import designParkingLot.repository.GateRepository;
import designParkingLot.repository.ParkingFloorRepository;
import designParkingLot.repository.ParkingLotRepository;
import designParkingLot.repository.ParkingSpotRepository;

public class InitialisationService {
	private ParkingLotRepository parkingLotRepository;
	private ParkingFloorRepository parkingFloorRepository;
	private ParkingSpotRepository parkingSpotRepository;
	private GateRepository gateRepository;
	
	
	
	public InitialisationService(ParkingLotRepository parkingLotRepository,
			ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository,
			GateRepository gateRepository) {
		this.parkingLotRepository = parkingLotRepository;
		this.parkingFloorRepository = parkingFloorRepository;
		this.parkingSpotRepository = parkingSpotRepository;
		this.gateRepository = gateRepository;
	}

	/***
	 * This will create a parking lot with 10 floors where each floor is having 100 spots for different vehicle types.
	 * @return ParkingLot object
	 */

	public ParkingLot initialise() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.setAddress("Area A, City C, State S");
		parkingLot.setId(1);
		parkingLot.setStatus(Status.ACTIVE);
		// add list of floors
		// add list of gates
		List<ParkingFloor> parkingFloors = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			ParkingFloor parkingFloor = new ParkingFloor();
			parkingFloor.setFloorNumber(i+1);
			parkingFloor.setId(i+1);
			parkingFloors.add(parkingFloor);
			parkingFloorRepository.put(parkingFloor);
		}
		for(int i=0; i<parkingFloors.size(); i++) {
			ParkingFloor parkingFloor = parkingFloors.get(i);
			List<ParkingSpot> parkingSpots = new ArrayList<>();
			for(int j=0; j<10; j++) {
				ParkingSpot spot = new ParkingSpot();
				spot.setId(j+1);
				spot.setNumber(j+1);
				spot.setStatus(Status.AVAILABLE);
				if(j<5) {
					spot.setVehicleType(VehicleType.TWO_WHEELER);
				}
				else {
					spot.setVehicleType(VehicleType.FOUR_WHEELER);
				}
				parkingSpotRepository.put(spot);
				parkingSpots.add(spot);
			}
			parkingFloor.setParkingSpots(parkingSpots);
			parkingFloorRepository.put(parkingFloor);
		}
		parkingLot.setParkingFloors(parkingFloors);
		
		Gate entryGate = new Gate();
		entryGate.setGateNumber(1);
		entryGate.setGateType(GateType.ENTRY);
		entryGate.setId(1);
		entryGate.setOperator("Ram Kumar");
		entryGate.setStatus(Status.ACTIVE);
		entryGate.setParkingLotId(1);
		
		Gate exitGate = new Gate();
		exitGate.setGateNumber(2);
		exitGate.setGateType(GateType.EXIT);
		exitGate.setId(2);
		exitGate.setOperator("Shyam Kumar");
		exitGate.setStatus(Status.ACTIVE);
		exitGate.setParkingLotId(1);
		
		gateRepository.put(entryGate);
		gateRepository.put(exitGate);
		
		parkingLot.setGates(List.of(entryGate, exitGate));
		
		parkingLotRepository.put(parkingLot);
		
		return parkingLot;
	}

}
