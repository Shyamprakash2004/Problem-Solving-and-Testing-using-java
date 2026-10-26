import java.util.Scanner;

// Interface
interface Payment {
    void pay(double amount);
    double calculateFinalAmount(double amount);
    String getPaymentName();
}

// Concrete Implementations
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        // Implementation of payment gateway connection can go here
    }
    
    @Override
    public double calculateFinalAmount(double amount) {
        return amount + (amount * 0.02); // 2% processing fee
    }

    @Override
    public String getPaymentName() {
        return "CreditCard";
    }
}

class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
    }
    
    @Override
    public double calculateFinalAmount(double amount) {
        return amount + (amount * 0.01); // 1% processing fee
    }

    @Override
    public String getPaymentName() {
        return "UPI";
    }
}

class NetBankingPayment implements Payment {
    @Override
    public void pay(double amount) {
    }
    
    @Override
    public double calculateFinalAmount(double amount) {
        return amount + (amount * 0.015); // 1.5% processing fee
    }

    @Override
    public String getPaymentName() {
        return "NetBanking";
    }
}

// Abstract Class
abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

// Concrete Processor
class OnlinePaymentProcessor extends PaymentProcessor {
    @Override
    double processPayment(Payment payment, double amount) {
        payment.pay(amount); // Triggers the void method
        return payment.calculateFinalAmount(amount); // Calculates actual final cost
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            PaymentProcessor processor = new OnlinePaymentProcessor();
            
            for (int i = 0; i < n; i++) {
                int paymentType = scanner.nextInt();
                double amount = scanner.nextDouble();
                
                Payment payment = null;
                
                if (paymentType == 1) {
                    payment = new CreditCardPayment();
                } else if (paymentType == 2) {
                    payment = new UPIPayment();
                } else if (paymentType == 3) {
                    payment = new NetBankingPayment();
                }
                
                if (payment != null) {
                    double finalAmount = processor.processPayment(payment, amount);
                    System.out.printf("%s %.2f\n", payment.getPaymentName(), finalAmount);
                }
            }
        }
        scanner.close();
    }
}
