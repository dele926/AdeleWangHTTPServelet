import java.io.Serializable;

public class Patient implements Serializable {
    //fields
    String name;
    int id;
    int phoneNumber;
    //constructor
    public Patient (String name, int id, int phoneNumber){
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }
}
