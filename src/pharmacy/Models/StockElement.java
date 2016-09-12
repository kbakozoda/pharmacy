package pharmacy.Models;

/**
 * Created by User on 11.09.2016.
 */
public class StockElement {
    private int id;
    private int drugId;
    private int priceOfSingle;
    private int pharmacyId;
    private int networkId;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public int getPriceOfSingle() {
        return priceOfSingle;
    }

    public void setPriceOfSingle(int priceOfSingle) {
        this.priceOfSingle = priceOfSingle;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
