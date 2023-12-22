package designParkingLot.repository;

import java.util.HashMap;
import java.util.Map;

import designParkingLot.exception.TokenNotFoundException;
import designParkingLot.models.Token;

public class TokenRepository {
	private Map<Integer, Token> tokenMap;

    public TokenRepository() {
        this.tokenMap = new HashMap<>();
    }

    public Token get(int TokenId){
        Token token  = tokenMap.get(TokenId);
        if(token == null){
            throw new TokenNotFoundException("Token not found for : "
                    + TokenId);
        }
        return token;
    }

    public void put(Token token) {
        tokenMap.put(token.getId(), token);
        System.out.println("Token has been added successfully");
    }

}
