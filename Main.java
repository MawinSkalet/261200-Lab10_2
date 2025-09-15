//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Somchai Jaidee");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);

        PayD payD = new XpayToPayDAdapter(xpay);

        // Print values from the adapted PayD interface
        System.out.println("Credit Card Number: " + payD.getCreditCardNo());
        System.out.println("Card Owner Name: " + payD.getCardOwnerName());
        System.out.println("Card Expiry Date: " + payD.getCardExpMonthYear());
        System.out.println("CVV: " + payD.getCVVNo());
        System.out.println("Total Amount: " + payD.getTotalAmount());
    }
}