package pharmacy.Models;

/**
 * Created by User on 11.09.2016.
 */
public class DrugType {
    private int id;
    private String name;// a single word. no spaces!

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
