package books.publishers;

public class Publisher {

    private int id;
    private String name;
    private String contactNo;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getContactNo() {
        return this.contactNo;
    }

}