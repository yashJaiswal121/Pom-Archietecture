package security;

import com.auth0.jwt.Algorithm;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import org.apache.commons.codec.binary.Base64;

import java.util.Map;
import java.util.Random;

public class JWTServiceImpl implements JWTService {

    private static JWTSigner.Options jwtSigningOptions;
    private static final String ISSUER = "DEMO_APPLICATION";
    private static final String SECRET_KEY = "HELLO_THIS_IS_A_SECRET_KEY_FOR_SIGNING_JWT_TOKEN";
    private static final String IAT = "IAT";
    private static final int SECONDS_UNTIL_EXPIRY = 3600;
    private Random random;
    private Base64 encoderDecoder;

    public JWTServiceImpl(){
        jwtSigningOptions = new JWTSigner.Options();
        jwtSigningOptions = jwtSigningOptions.setAlgorithm(Algorithm.HS512);
        jwtSigningOptions = jwtSigningOptions.setExpirySeconds(SECONDS_UNTIL_EXPIRY);
        jwtSigningOptions= jwtSigningOptions.setIssuedAt(true);
        random = new Random();
        encoderDecoder = new Base64(true);
    }

    private String getSecretKey(){
        return SECRET_KEY;
    }

    public String createAccessToken(Map<String, Object> claims) {
        try{
                long iat = System.currentTimeMillis()/1000;

                //For Handling a case where Same userid/password is logined at a same time
                byte[] entropy = new byte[16];
                random.nextBytes(entropy);

                JWTSigner jwtSigner = new JWTSigner(getSecretKey());

                claims.put("ISSUER",ISSUER);
                claims.put(IAT,iat);
                claims.put("ENTROPY",encoderDecoder.encodeAsString(entropy));

                return jwtSigner.sign(claims,jwtSigningOptions);
        }catch (Exception e){
            System.out.println("Error in creating JWT Access TOKEN....");
        }
        return null;
    }

    public Map<String, Object> verifyToken(String jwtToken) {
        try{
            JWTVerifier jwtVerifier = new JWTVerifier(getSecretKey());
            Map<String,Object> claims = jwtVerifier.verify(jwtToken);
            return claims;
        }catch (Exception ex){
            System.out.println("Error in getting claims from token!...");
        }
        return null;
    }
}
