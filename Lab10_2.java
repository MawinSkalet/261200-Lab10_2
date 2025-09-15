public class Lab10_2 {
    public static void main(String[] args) {
        // Create and populate Xpay object with test data
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Somchai Jaidee");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);

        // Create adapter to convert Xpay to PayD interface
        PayD payD = new XpayToPayDAdapter(xpay);

        // Display original Xpay values
        System.out.println("=== Original Xpay Values ===");
        System.out.println("Credit Card No: " + xpay.getCreditCardNo());
        System.out.println("Customer Name: " + xpay.getCustomerName());
        System.out.println("Card Exp Month: " + xpay.getCardExpMonth());
        System.out.println("Card Exp Year: " + xpay.getCardExpYear());
        System.out.println("CVV: " + xpay.getCardCVVNo());
        System.out.println("Amount: " + xpay.getAmount());

        System.out.println("\n=== Adapted PayD Values ===");
        // Print values from the adapted PayD interface
        System.out.println("Credit Card Number: " + payD.getCreditCardNo());
        System.out.println("Card Owner Name: " + payD.getCardOwnerName());
        System.out.println("Card Expiry Date: " + payD.getCardExpMonthYear());
        System.out.println("CVV: " + payD.getCVVNo());
        System.out.println("Total Amount: " + payD.getTotalAmount());

        // Demonstrate that changes through adapter affect original object
        System.out.println("\n=== Testing Adapter Updates ===");
        payD.setTotalAmount(3000.00);
        payD.setCardOwnerName("Updated Name");

        System.out.println("Updated amount through adapter: " + payD.getTotalAmount());
        System.out.println("Original Xpay amount: " + xpay.getAmount());
        System.out.println("Updated name through adapter: " + payD.getCardOwnerName());
        System.out.println("Original Xpay name: " + xpay.getCustomerName());
    }
}