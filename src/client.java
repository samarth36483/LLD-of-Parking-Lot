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
		GenerateTokenRequestDTO requestDTO = new GenerateTokenRequestDTO("RJ36CA6636", VehicleType.FOUR_WHEELER, 1);
		
		GeneratedTokenResponseDTO responseDTO = client.tokenController.getToken(requestDTO);
		System.out.println(responseDTO.getToken().toString());
		System.out.println(responseDTO.getMessage());
		System.out.println(responseDTO.getStatus());
		
		GenerateTokenRequestDTO requestDTO1 = new GenerateTokenRequestDTO("RJ19CA0666", VehicleType.TWO_WHEELER, 1);
		
		GeneratedTokenResponseDTO responseDTO1 = client.tokenController.getToken(requestDTO1);
		System.out.println(responseDTO1.getToken().toString());
		System.out.println(responseDTO1.getMessage());
		System.out.println(responseDTO1.getStatus());
		
		GenerateTokenRequestDTO requestDTO2 = new GenerateTokenRequestDTO("RJ20CA1234", VehicleType.FOUR_WHEELER, 1);
		
		GeneratedTokenResponseDTO responseDTO2 = client.tokenController.getToken(requestDTO2);
		System.out.println(responseDTO2.getToken().toString());
		System.out.println(responseDTO2.getMessage());
		System.out.println(responseDTO2.getStatus());
	}

}
