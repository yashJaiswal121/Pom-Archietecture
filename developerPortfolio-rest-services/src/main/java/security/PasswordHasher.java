package security;

public interface PasswordHasher {
    byte[] createSecurePassword(String plainTextPassword,byte[] salt);
}
