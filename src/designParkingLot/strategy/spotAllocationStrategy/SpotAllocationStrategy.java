package designParkingLot.strategy.spotAllocationStrategy;

import designParkingLot.models.Gate;
import designParkingLot.models.ParkingSpot;
import designParkingLot.models.enums.VehicleType;

public interface SpotAllocationStrategy {
	ParkingSpot getSpot(VehicleType vehicleType, Gate gate);

}
