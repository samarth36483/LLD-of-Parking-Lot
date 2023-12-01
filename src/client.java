import designParkingLot.controllers.TokenController;
import designParkingLot.dto.GenerateTokenRequestDTO;
import designParkingLot.dto.GeneratedTokenResponseDTO;
import designParkingLot.models.ParkingLot;
import designParkingLot.models.Token;
import designParkingLot.models.enums.VehicleType;
import designParkingLot.repository.GateRepository;
import designParkingLot.repository.ParkingFloorRepository;
import designParkingLot.repository.ParkingLotRepository;
import designParkingLot.repository.ParkingSpotRepository;
import designParkingLot.repository.TokenRepository;
import designParkingLot.service.InitialisationService;
import designParkingLot.service.TokenService;

public class Client {
	private InitialisationService initialisationService;
	private TokenController tokenController;

	public Client() {
		ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TokenRepository ticketRepository = new TokenRepository();
        GateRepository gateRepository = new GateRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        
		this.initialisationService = new InitialisationService(parkingLotRepository, parkingFloorRepository, parkingSpotRepository, gateRepository);
		this.tokenController = new TokenController(new TokenService(ticketRepository, parkingLotRepository, gateRepository));
	}

	public static void main(String[] args) {
		Client client = new Client();
		ParkingLot parkingLot = client.initialisationService.initialise();
		GenerateTokenRequestDTO requestDTO = new GenerateTokenRequestDTO();
		requestDTO.setVehicleNumber("RJ36CA6636");
		requestDTO.setVehicleType(VehicleType.FOUR_WHEELER);
		requestDTO.setGateId(1);
		
		GeneratedTokenResponseDTO responseDTO = client.tokenController.getToken(requestDTO);
		System.out.println(responseDTO.getToken().getEntryTime());
//		//System.out.println(token.getId());
//		System.out.println(token.getEntryTime());
//		System.out.println(token.getParkingSpot().getId());
//		System.out.println(token.getParkingSpot().getNumber());
//		System.out.println(token.getVehicle().getVehicleNumber());
//		System.out.println(token.getVehicle().getVehicleType());
	}

}
