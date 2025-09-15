public class XpayToPayDAdapter implements PayD {
    private Xpay xpay;

    /**
     * Constructor - takes an Xpay object to adapt
     * @param xpay The Xpay object to be adapted to PayD interface
     */
    public XpayToPayDAdapter(Xpay xpay) {
        this.xpay = xpay;
    }

    @Override
    public long getCreditCardNo() {
        // Convert String to long
        try {
            return Long.parseLong(xpay.getCreditCardNo());
        } catch (NumberFormatException e) {
            // Handle conversion error gracefully
            System.err.println("Error converting credit card number: " + e.getMessage());
            return 0L;
        }
    }

    @Override
    public void setCreditCardNo(long creditCardNo) {
        // Convert long to String
        xpay.setCreditCardNo(String.valueOf(creditCardNo));
    }

    @Override
    public String getCardOwnerName() {
        // Direct mapping - same data type
        return xpay.getCustomerName();
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        // Direct mapping - same data type
        xpay.setCustomerName(cardOwnerName);
    }

    @Override
    public String getCardExpMonthYear() {
        // Combine month and year into MM/YY format
        String month = xpay.getCardExpMonth();
        String year = xpay.getCardExpYear();

        if (month != null && year != null) {
            return month + "/" + year;
        }
        return null;
    }

    @Override
    public void setCardExpMonthYear(String cardExpMonthYear) {
        // Split MM/YY format back to separate month and year
        if (cardExpMonthYear != null && cardExpMonthYear.contains("/")) {
            String[] parts = cardExpMonthYear.split("/");
            if (parts.length == 2) {
                xpay.setCardExpMonth(parts[0]);
                xpay.setCardExpYear(parts[1]);
            }
        }
    }

    @Override
    public Integer getCVVNo() {
        // Convert Short to Integer
        Short cvv = xpay.getCardCVVNo();
        return cvv != null ? cvv.intValue() : null;
    }

    @Override
    public void setCVVNo(Integer cVVNo) {
        // Convert Integer to Short
        if (cVVNo != null) {
            xpay.setCardCVVNo(cVVNo.shortValue());
        }
    }

    @Override
    public Double getTotalAmount() {
        // Direct mapping - same data type
        return xpay.getAmount();
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        // Direct mapping - same data type
        xpay.setAmount(totalAmount);
    }
}