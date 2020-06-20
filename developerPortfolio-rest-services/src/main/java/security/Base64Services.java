package security;

public interface Base64Services {
    public byte[] encode(byte[] input);
    public byte[] decode(String input);
}
