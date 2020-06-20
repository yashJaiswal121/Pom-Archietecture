package security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import java.security.Security;

public class Base64ServicesImpl implements Base64Services {

    static {
        try{
            Security.addProvider(new BouncyCastleProvider());
        }catch (Exception e){
            System.out.println("Error in initializing jce provider...");
        }
    }
    public byte[] encode(byte[] input) {
         return Base64.encode( input );
    }

    public byte[] decode(String encodedString) {
        return Base64.decode( encodedString );
    }
}
