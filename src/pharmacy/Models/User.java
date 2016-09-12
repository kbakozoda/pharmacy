package pharmacy.Models;

/**
 * Created by User on 04.09.2016.
 */
public class User {
    private String username;
    private int role; /**role id*/
    private String password;
    private String name;
    private String surname;
    private int id;
    private int pharmacyId = null; // for pharmacists;
    private int networkdId = null; // for admins;

    public void setPharmacyId(int pharmacyId) {// is used when: login->role=pharmacist->found pharmacy
        this.pharmacyId = pharmacyId;
    }

    public void setNetworkdId(int networkdId) {// is used when: login->role=admin->found network
        this.networkdId = networkdId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public int getNetworkdId() {
        return networkdId;
    }
}
