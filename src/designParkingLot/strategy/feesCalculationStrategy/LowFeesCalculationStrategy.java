package designParkingLot.strategy.feesCalculationStrategy;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import designParkingLot.models.Token;
import designParkingLot.models.enums.VehicleType;

public class LowFeesCalculationStrategy implements FeesCalculationStrategy {
	private static final int farePerMinuteForTwoWheeler = 2;
	private static final int farePerMinuteForFourWheeler = 5;

	@Override
	public double getFare(Token token) {
		LocalDateTime entryTime = token.getEntryTime();
		LocalDateTime currentTime = LocalDateTime.now();
		int noOfMinutes = (int)ChronoUnit.MINUTES.between(currentTime, entryTime);
		if(token.getVehicle().getVehicleType().equals(VehicleType.TWO_WHEELER)) {
			return noOfMinutes*farePerMinuteForTwoWheeler;
		}
		else {
			return noOfMinutes*farePerMinuteForFourWheeler;
		}
	}

}
