package seedu.addressbook.data.person;

public class Street {
    private final String value;
    
    public Street(String street){
        this.value = street;
    }
    
    public String getValue(){
        return this.value;
    }
}
