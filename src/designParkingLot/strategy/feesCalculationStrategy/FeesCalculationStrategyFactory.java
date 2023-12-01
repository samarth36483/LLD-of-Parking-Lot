package designParkingLot.strategy.feesCalculationStrategy;

public class FeesCalculationStrategyFactory {
	public static FeesCalculationStrategy getFeesCalculationStrategy() {
		return new LowFeesCalculationStrategy();
	}

}
