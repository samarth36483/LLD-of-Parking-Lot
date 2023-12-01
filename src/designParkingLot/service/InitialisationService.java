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
		super();
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
		
		for(int i=1; i<=10; i++) {
			ParkingFloor parkingFloor = new ParkingFloor();
			parkingFloor.setFloorNumber(i);
			parkingFloor.setId(i);
			List<ParkingSpot> parkingSpots = new ArrayList<>();
			for(int j=1; j<=100; j++) {
				ParkingSpot spot = new ParkingSpot();
				spot.setId(i*10);
				spot.setNumber(i);
				spot.setStatus(Status.ACTIVE);
				if(i<=50) {
					spot.setVehicleType(VehicleType.TWO_WHEELER);
				}
				else {
					spot.setVehicleType(VehicleType.FOUR_WHEELER);
				}
				parkingSpots.add(spot);
				parkingSpotRepository.put(spot);
			}
			parkingFloor.setParkingSpots(parkingSpots);
			parkingFloorRepository.put(parkingFloor);
			parkingFloors.add(parkingFloor);
		}
		parkingLot.setParkingFloors(parkingFloors);
		
		Gate entryGate = new Gate();
		entryGate.setGateNumber(1);
		entryGate.setGateType(GateType.ENTRY);
		entryGate.setId(1);
		entryGate.setOperator("Ram Kumar");
		entryGate.setStatus(Status.ACTIVE);
		
		Gate exitGate = new Gate();
		exitGate.setGateNumber(2);
		exitGate.setGateType(GateType.EXIT);
		exitGate.setId(2);
		exitGate.setOperator("Shyam Kumar");
		exitGate.setStatus(Status.ACTIVE);
		
		gateRepository.put(entryGate);
		gateRepository.put(exitGate);
		
		parkingLot.setGates(List.of(entryGate, exitGate));
		
		parkingLotRepository.put(parkingLot);
		
		return parkingLot;
	}

}
