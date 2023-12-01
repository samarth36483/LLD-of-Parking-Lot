package designParkingLot.service;

import java.time.LocalDateTime;

import designParkingLot.models.Gate;
import designParkingLot.models.ParkingSpot;
import designParkingLot.models.Token;
import designParkingLot.models.Vehicle;
import designParkingLot.models.enums.Status;
import designParkingLot.models.enums.VehicleType;
import designParkingLot.repository.GateRepository;
import designParkingLot.repository.ParkingLotRepository;
import designParkingLot.repository.TokenRepository;
import designParkingLot.strategy.spotAllocationStrategy.SpotAllocationFactory;
import designParkingLot.strategy.spotAllocationStrategy.SpotAllocationStrategy;

public class TokenService {
	private TokenRepository tokenRepository;
	private ParkingLotRepository parkingLotRepository;
	private GateRepository gateRepository;
	
	public TokenService(TokenRepository tokenRepository, ParkingLotRepository parkingLotRepository,
			GateRepository gateRepository) {
		this.tokenRepository = tokenRepository;
		this.parkingLotRepository = parkingLotRepository;
		this.gateRepository = gateRepository;
	}
	
	public Token getToken(String vehicleNumber, VehicleType vehicleType, int gateId) {
		Gate gate = gateRepository.get(gateId);
		SpotAllocationStrategy spotAllocationStrategy = SpotAllocationFactory.getSpotAllocationStrategy(parkingLotRepository);
		ParkingSpot spot = spotAllocationStrategy.getSpot(vehicleType, gate);
		spot.setStatus(Status.OCCUPIED);
		
		Token token = new Token();
		token.setEntryTime(LocalDateTime.now());
		token.setParkingSpot(spot);
		token.setVehicle(new Vehicle(vehicleNumber, vehicleType));
		
		return token;
	}
}
