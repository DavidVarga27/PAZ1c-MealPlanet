
package sk.upjs.ics.mealplanet;


public class Relation {
    long id;
    long idR;
    long idI;
    String amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdR() {
        return idR;
    }

    public void setIdR(long idR) {
        this.idR = idR;
    }

    public long getIdI() {
        return idI;
    }

    public void setIdI(long idI) {
        this.idI = idI;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
        
}