package stor.src;

public class Clothes extends Products {
    private String color;
    private String gender;
    private int size;
    private String company;

    public Clothes(
            int id,
            String name,
            double price,
            int quantity,
            String color,
            String gender,
            int size,
            String company) {
        super(id,name, price, quantity);
        this.color = color;
        this.gender = gender;
        this.size = size;
        this.company = company;
    }

    public Clothes(){

    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return gender;
    }

    public void setType(String type) {
        this.gender = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothes{" + super.toString()+
                "color='" + color + '\'' +
                ", gender ='" + gender + '\'' +
                ", size=" + size + '\''+
                ", company = "+ company +
                '}';
    }
}
