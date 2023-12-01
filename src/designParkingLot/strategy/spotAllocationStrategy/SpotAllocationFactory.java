package designParkingLot.strategy.spotAllocationStrategy;

import designParkingLot.repository.ParkingLotRepository;

public class SpotAllocationFactory {
	public static SpotAllocationStrategy getSpotAllocationStrategy(ParkingLotRepository parkingLotRepository){
        return new RandomSpotAllocationStrategy(parkingLotRepository);
    }

}
