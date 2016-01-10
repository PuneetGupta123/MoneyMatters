package dell.moneymatters;

/**
 * Created by dell on 1/10/2016.
 */
public class MoneyFeedItem {
    Integer  id;
    String personName;
    Integer amount;
    String rateOfInterest;
    String securityNeeded;

    public MoneyFeedItem() {
    }

    public MoneyFeedItem(Integer id, String personName, Integer amount, String rateOfInterest, String securityNeeded) {
        this.id = id;
        this.personName = personName;
        this.amount = amount;
        this.rateOfInterest = rateOfInterest;
        this.securityNeeded = securityNeeded;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(String rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getSecurityNeeded() {
        return securityNeeded;
    }

    public void setSecurityNeeded(String securityNeeded) {
        this.securityNeeded = securityNeeded;
    }
}
