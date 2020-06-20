package security;

public interface PasswordService {
    public String createPassword(String plainTextPswd);
    public boolean authenticatePassword(String inputPassword,String encodedHashedDbPassword);
}
