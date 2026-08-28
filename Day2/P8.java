// Variation A: Read-Only Encapsulation
class ServerStatus {
    private final String serverIp; // 'final' ensures it cannot be reassigned
    private final String status;

    public ServerStatus(String serverIp, String status) {
        this.serverIp = serverIp;
        this.status = status;
    }

    // Only getters provided (values can be read, but never changed externally)
    public String getServerIp() {
        return this.serverIp;
    }

    public String getStatus() {
        return this.status;
    }
}

// Variation B: Write-Only Encapsulation
class SecurityKeyStore {
    private String privateApiKey;

    // Only setter provided (API key cannot be read back directly)
    public void setApiKey(String key) {
        if (key != null && key.length() >= 8) {
            this.privateApiKey = key;
            System.out.println("API Key saved securely.");
        } else {
            System.out.println("Invalid key: Must be at least 8 characters.");
        }
    }

    // Internal verification without ever exposing the private variable
    public boolean authenticate(String inputKey) {
        return this.privateApiKey != null && this.privateApiKey.equals(inputKey);
    }
}

public class P8 {
    public static void main(String[] args) {
        // --- 1. Read-Only Usage ---
        ServerStatus server = new ServerStatus("192.168.1.1", "ONLINE");
        System.out.println("Server: " + server.getServerIp() + " | Status: " + server.getStatus());

        // --- 2. Write-Only Usage ---
        SecurityKeyStore keyStore = new SecurityKeyStore();
        keyStore.setApiKey("Secret_Token_99");

        // Verify key securely without reading it
        System.out.println("Auth (wrong): " + keyStore.authenticate("wrong_pass"));
        System.out.println("Auth (correct): " + keyStore.authenticate("Secret_Token_99"));
    }
}
