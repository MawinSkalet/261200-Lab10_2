
public interface PayD {
    long getCreditCardNo();
    String getCardOwnerName();
    String getCardExpMonthYear();
    Integer getCVVNo();
    Double getTotalAmount();

    void setCreditCardNo(long creditCardNo);
    void setCardOwnerName(String cardOwnerName);
    void setCardExpMonthYear(String cardExpMonthYear);
    void setCVVNo(Integer cVVNo);
    void setTotalAmount(Double totalAmount);
}