
/**
 *
 * @author Sandun Chandrasiri (K2322528 / E119775)
 */
public class Treatment {
    private int id,sellingPrice;
    private String name,description;

    public Treatment() {
        this.id = 0;
        this.sellingPrice = 0;
        this.name = "";
        this.description = "";
    }

    public Treatment(int id, int sellingPrice, String name, String description) {
        this.id = id;
        this.sellingPrice = sellingPrice;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Treatment{" + "id=" + id  + ", sellingPrice=" + sellingPrice +  ", name=" + name + ", description=" + description + '}';
    }
    
    
}
