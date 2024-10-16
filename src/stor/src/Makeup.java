package stor.src;

public class Makeup extends Products{
    private String company;
    private String usage;

    public Makeup(int id,
                  String name,
                  double price,
                  int quantity,
                  String company,
                  String usage
    ) {
        super(id ,name, price, quantity);
        this.company = company;
        this.usage = usage;
    }

    public Makeup(){

    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Makeup{" + super.toString()+
                "usage='" + usage + '\'' +
                ", The company='" + company + '\'' +
                '}';
    }
}
