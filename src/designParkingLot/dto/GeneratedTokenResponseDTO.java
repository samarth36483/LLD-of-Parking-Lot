package designParkingLot.dto;

import designParkingLot.models.Token;

public class GeneratedTokenResponseDTO {
	private Token token;
	private String message;
	private ResponseStatus status;
	
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseStatus getStatus() {
		return status;
	}
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "GeneratedTokenResponseDTO [token=" + token + ", message=" + message + ", status=" + status + "]";
	}
	
	
}
