package security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Security;

public class PasswordHasherImpl implements PasswordHasher {

    private static final int ITERATIONS = 1000;
    private static final String DIGEST_ALGO = "SHA-512";
    private static final String CHARACTER_ENCODING = "UTF-8";
    private MessageDigest digest = null;

    static {
        try{
            Security.addProvider(new BouncyCastleProvider());
        }catch (Throwable ex){
            System.out.println("Exception while initlializing JCE in Password Hasher...");
        }
    }

    public byte[] createSecurePassword(String plainTextPassword, byte[] salt) {
        try{
            digest = null;
            digest = MessageDigest.getInstance(DIGEST_ALGO);
            digest.reset();
            digest.update(salt);
            byte[] hashedBytes = getHashedBytes(plainTextPassword.getBytes(CHARACTER_ENCODING));

            //Now iterating for making secure hash password
            for(int i =1; i<=ITERATIONS; i++){
               hashedBytes = getHashedBytes(hashedBytes);
            }
            return hashedBytes;
        }catch(Exception e){
            System.out.println("Error in Generating secure hash password!");
        }
        return null;
    }

    private byte[] getHashedBytes(byte [] input){
        digest.reset();
        byte[] hasedBytes = digest.digest(input);
        return hasedBytes;
    }
}
