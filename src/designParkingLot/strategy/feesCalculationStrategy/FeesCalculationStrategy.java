package designParkingLot.strategy.feesCalculationStrategy;

import designParkingLot.models.Token;

public interface FeesCalculationStrategy {
	public double getFare(Token token);

}
