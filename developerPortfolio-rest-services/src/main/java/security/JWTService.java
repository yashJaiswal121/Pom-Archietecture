package security;

import com.auth0.jwt.JWTVerifyException;
import entities.User;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

public interface JWTService {


    /**
     * Sign a set of claims with the JSON Web Token (JWT) algorithm
     *
     * @param claims A map of variables to convert to an encoded JWT
     * @return The encoded JWT
     */

    public String createAccessToken(Map<String,Object> claims);

    /*
     * @param jwt The encoded JWT string
     * @return The decoded JWT as a map of objects
     * @throws SignatureException The signature is invalid
     * @throws NoSuchAlgorithmException The algorithm defined in the JWT is not valid or is missing
     * @throws InvalidKeyException The private key being used to verify the JWT is incorrect
     * @throws JWTVerifyException The token being verified is invalid. Ex: Expired token
    */
    public Map<String,Object> verifyToken(String jwtToken);
}
