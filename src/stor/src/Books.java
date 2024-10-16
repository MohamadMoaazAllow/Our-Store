package stor.src;

public class Books extends Products{

    private String editor_name;
    private int numberOfPages;
    private String type;

    public Books(
            int id ,
            String name,
            double price,
            int quantity,
            String editor_name,
            int numberOfPages,
            String type) {

        super(id,name, price, quantity);
        this.editor_name = editor_name;
        this.numberOfPages = numberOfPages;
        this.type = type;
    }
    public Books(){

    }

    @Override
    public String toString() {
        return "Books{" +super.toString()+
                "editor_name='" + editor_name + '\'' +
                ", number Of Pages=" + numberOfPages +'\''+
                "type = "+ type +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEditor_name() {
        return editor_name;
    }

    public void setEditor_name(String editor_name) {
        this.editor_name = editor_name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
