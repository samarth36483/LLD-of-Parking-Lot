package designParkingLot.controllers;

import designParkingLot.dto.GenerateTokenRequestDTO;
import designParkingLot.dto.GeneratedTokenResponseDTO;
import designParkingLot.dto.ResponseStatus;
import designParkingLot.exception.InvalidRequestDataException;
import designParkingLot.models.Token;
import designParkingLot.service.TokenService;

public class TokenController {
	private TokenService tokenService;

	public TokenController(TokenService tokenService) {
		this.tokenService = tokenService;
	}
	
	public GeneratedTokenResponseDTO getToken(GenerateTokenRequestDTO dto) {
		GeneratedTokenResponseDTO responseDTO = new GeneratedTokenResponseDTO();
		Token token;
		try {
			if(dto.getVehicleNumber() == null || dto.getVehicleType() == null || dto.getGateId() == 0) {
				throw new InvalidRequestDataException("Request data is invalid");
			}
			token = tokenService.getToken(dto.getVehicleNumber(), dto.getVehicleType(), dto.getGateId());
			responseDTO.setStatus(ResponseStatus.SUCCESS);
			responseDTO.setToken(token);
			responseDTO.setMessage("Token generated sucessfully with token Id: " + token.getId());
		}
		catch(Exception e) {
			responseDTO.setStatus(ResponseStatus.FAILED);
			responseDTO.setMessage(e.getMessage());
		}
		
		return responseDTO;
	}

}
