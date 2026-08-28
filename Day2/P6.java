class UserProfile {
    // 1. private: Hidden completely from outside; accessible only via getters/setters
    private String socialSecurityPin;

    // 2. default (no keyword): Accessible by any class in the same package
    String username;

    // 3. protected: Accessible in same package and by derived/sub classes
    protected String membershipType;

    // 4. public: Accessible everywhere
    public String country;

    // Constructor
    public UserProfile(String username, String pin, String membershipType) {
        this.username = username;
        this.socialSecurityPin = pin;
        this.membershipType = membershipType;
        this.country = "India";
    }

    // Getter for private field
    public String getMaskedPin() {
        return "***" + this.socialSecurityPin.substring(this.socialSecurityPin.length() - 2);
    }

    // Setter for private field with input validation
    public void updatePin(String newPin) {
        if (newPin != null && newPin.length() == 4) {
            this.socialSecurityPin = newPin;
            System.out.println("PIN updated successfully.");
        } else {
            System.out.println("Invalid PIN format. Must be 4 digits.");
        }
    }
}

public class P6 {
    public static void main(String[] args) {
        UserProfile user = new UserProfile("alex_dev", "4589", "Premium");

        // Public, Protected, and Default fields are directly readable in the same package
        System.out.println("Username (default): " + user.username);
        System.out.println("Membership (protected): " + user.membershipType);
        System.out.println("Country (public): " + user.country);

        // Direct access: user.socialSecurityPin would trigger a COMPILE ERROR
        // Read private data safely through public getter:
        System.out.println("PIN (private via getter): " + user.getMaskedPin());

        // Update private data safely through public setter:
        user.updatePin("12");   // Fails validation
        user.updatePin("9876"); // Succeeds validation
        System.out.println("Updated PIN: " + user.getMaskedPin());
    }
}
