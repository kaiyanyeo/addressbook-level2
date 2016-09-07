package seedu.addressbook.data.person;

/**
 * Represents a Person's common contact details in the address book.
 */
public class Contact {

    public final String value;
    protected boolean isPrivate;
    
    /**
     * Constructs given information.
     */
    public Contact(String contact, boolean isPrivate) {
        this.isPrivate = isPrivate;
        contact = contact.trim();
        this.value = contact;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}