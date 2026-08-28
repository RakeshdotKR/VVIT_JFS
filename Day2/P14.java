// Interface contract
interface PaymentGateway {
    void pay(double amount);
}

// Implementation 1
class CreditCardGateway implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Rs" + amount + " via Credit Card (2% transaction fee applied).");
    }
}

// Implementation 2
class UpiGateway implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Rs" + amount + " instantly via UPI QR scanner.");
    }
}

// Context Class: Relies on the polymorphic interface, not concrete classes
class CheckoutService {
    private PaymentGateway gateway;

    // Injects payment implementation dynamically at runtime
    public void setPaymentGateway(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void completeOrder(double totalAmount) {
        if (gateway == null) {
            System.out.println("Error: No payment method selected.");
            return;
        }
        gateway.pay(totalAmount);
    }
}

public class P14 {
    public static void main(String[] args) {
        CheckoutService checkout = new CheckoutService();

        // 1. Pay using Credit Card
        checkout.setPaymentGateway(new CreditCardGateway());
        checkout.completeOrder(150.00);

        // 2. Switch payment method dynamically at runtime to UPI
        checkout.setPaymentGateway(new UpiGateway());
        checkout.completeOrder(75.50);
    }
}
