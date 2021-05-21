import java.io.Serializable;
import java.util.Objects;

public class AddressBook implements Serializable {

    Person person;
    Contact contact;

    String addressBookName;

    public AddressBook() {
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public Person getPerson() {

        return person;
    }

    public void setPerson(Person person) {

        this.person = person;
    }

    public Contact getContact() {

        return contact;
    }

    public void setContact(Contact contact) {

        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return person.equals(that.person) && contact.equals(that.contact) && addressBookName.equals(that.addressBookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, contact, addressBookName);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressUtility addressUtility = new AddressUtility();
        addressUtility.operation(AddressUtility.choice());

    }
}



