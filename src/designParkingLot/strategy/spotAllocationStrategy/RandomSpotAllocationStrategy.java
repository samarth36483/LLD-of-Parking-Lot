package designParkingLot.strategy.spotAllocationStrategy;

import designParkingLot.exception.ParkingSpotNotFoundException;
import designParkingLot.models.Gate;
import designParkingLot.models.ParkingFloor;
import designParkingLot.models.ParkingLot;
import designParkingLot.models.ParkingSpot;
import designParkingLot.models.enums.Status;
import designParkingLot.models.enums.VehicleType;
import designParkingLot.repository.GateRepository;
import designParkingLot.repository.ParkingFloorRepository;
import designParkingLot.repository.ParkingLotRepository;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy {
	private ParkingLotRepository parkingLotRepository;
	

	public RandomSpotAllocationStrategy(ParkingLotRepository parkingLotRepository) {
		super();
		this.parkingLotRepository = parkingLotRepository;
	}


	@Override
	public ParkingSpot getSpot(VehicleType vehicleType, Gate gate) {
		ParkingLot parkingLot = parkingLotRepository.getParkingLotFromGate(gate);
		int currentFloor = gate.getFloorNumber();
		
		ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(currentFloor);
		for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
			if(parkingSpot.getVehicleType().equals(vehicleType) && 
					parkingSpot.getStatus().equals(Status.AVAILABLE)) {
				return parkingSpot;
			}
		}
		for(ParkingFloor parkingFloor1 : parkingLot.getParkingFloors()) {
			for(ParkingSpot parkingSpot : parkingFloor1.getParkingSpots()) {
				if(parkingSpot.getVehicleType().equals(vehicleType) && 
						parkingSpot.getStatus().equals(Status.AVAILABLE)) {
					return parkingSpot;
				}
			}
		}
		throw new ParkingSpotNotFoundException("No Parking spot available for this vehicle type");
	}

}
