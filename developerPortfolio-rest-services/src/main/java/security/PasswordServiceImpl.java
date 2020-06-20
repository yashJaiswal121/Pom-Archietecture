package security;


import java.security.SecureRandom;

public class PasswordServiceImpl implements PasswordService{

    private static final int SALT_SIZE = 12;
    private SecureRandom random;
    private static PasswordHasher passwordHasher;
    private static Base64Services base64;

    public PasswordServiceImpl(){
        random = new SecureRandom();
        passwordHasher = new PasswordHasherImpl();
        base64 = new Base64ServicesImpl();
    }

    public String createPassword(String plainTextPswd) {
        //Creation of a hash based password...
        try{
            //Prepration of salt with random Bytes
            byte[] salt = new byte[SALT_SIZE];
            random = new SecureRandom();
            random.nextBytes(salt);
            //...which will be saved to db after string conversion
            String securedHashedPassword = createPassword(plainTextPswd,salt);
            return securedHashedPassword;
                }catch (Exception e){
            System.out.println("Error in Creation of Secured Password...");
        }
        return null;
    }

    private String createPassword(String plainTextPassword,byte[] salt){

        try{
            //Creation of password with salt of random bytes...
            byte[] securePasswordBytesWithoutSalt = passwordHasher.createSecurePassword(plainTextPassword,salt);

            //Combining those random bytes[Salt] and Hashed passwords in a new Array(securePasswordBytesWithSalt)
            byte[] securePasswordBytesWithSalt = new byte[SALT_SIZE+securePasswordBytesWithoutSalt.length];
            System.arraycopy(salt,0,securePasswordBytesWithSalt,0,SALT_SIZE);
            System.arraycopy(securePasswordBytesWithoutSalt,0,securePasswordBytesWithSalt,SALT_SIZE,securePasswordBytesWithoutSalt.length);

            //Converting this byte array into string...
            return new String(base64.encode(securePasswordBytesWithSalt),"UTF-8");
        }catch (Exception e){
            System.out.println("Error in Creation of Secured Password...");
        }
        return null;
    }

    public boolean authenticatePassword(String inputPassword,String encodedHashedDbPassword) {
        try{
            byte[] decodedHashedValidPassword = base64.decode(encodedHashedDbPassword);
            //Extraction of Salt Bytes from decoded Password(Saved in db)...
            byte[] salt = new byte[SALT_SIZE];
            System.arraycopy(decodedHashedValidPassword,0,salt,0,SALT_SIZE);

            //Creation of Hashed Password from inputPassword and then checking if it equals to Hashed Password saved in db..
            String preparedPassword = createPassword(inputPassword,salt);
            if(preparedPassword.equalsIgnoreCase(encodedHashedDbPassword)){
                return true;
            }
        }catch (Exception e){
            System.out.println("Error in validating Password ....");
        }
        return false;
    }
}
