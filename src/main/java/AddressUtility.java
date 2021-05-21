import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressUtility {

    List<AddressBook> addressBooks = new ArrayList<>();

     void operation(int choice){
         AddressUtility addressUtility = new AddressUtility();

         switch (choice){
            case 1:
                addRecord(addressBooks);
                addressUtility.operation(AddressUtility.choice());
            case 2:showRecord(addressBooks);
                addressUtility.operation(AddressUtility.choice());
            case 3:deleteRecord();
                addressUtility.operation(AddressUtility.choice());
           // case 4:
            default:
                addressUtility.operation(AddressUtility.choice());
        }
    }


    static int choice(){
        System.out.println("Enter your prefered choice from below list");
        System.out.println("1 for add address book");
        System.out.println("2 for show address book");
        System.out.println("3 for search address book");
        System.out.println("4 for delete address book");
        Scanner in = new Scanner(System.in);
        System.out.println("please enter operation number");
        return in.nextInt();
    }

    static void addRecord(List<AddressBook> addressBooks){

        AddressBook addressBook = new AddressBook();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Address book name");
        String s = in.nextLine();
        addressBook.setAddressBookName(s);
        Person person = new Person();
        Contact contact = new Contact();
        System.out.println("Enter first name ");
        s = in.nextLine();
        person.setFirstName(s);
        System.out.println("Enter last name ");
        s = in.nextLine();
        person.setLastName(s);
        System.out.println("Enter city ");
        s = in.nextLine();
        contact.setCity(s);
        System.out.println("Enter email ");
        s = in.nextLine();
        contact.setEmail(s);
        System.out.println("Enter state ");
        s = in.nextLine();
        contact.setState(s);
        System.out.println("Enter phone number ");
        int a = in.nextInt();
        contact.setPhoneNumber(a);
        System.out.println("Enter zipcode ");
        a = in.nextInt();
        contact.setZipCode(a);
        checkIfFirstNameDuplicate(person,contact, addressBooks);
    }

    void showRecord(List<AddressBook> addressBooks){
         addressBooks.stream().forEach(addressBook -> {

            System.out.println("FirstName = " + addressBook.getPerson().getFirstName());
            System.out.println("lastName = " + addressBook.getPerson().getLastName());
            System.out.println("City = " + addressBook.getContact().getCity());
            System.out.println("Email = " + addressBook.getContact().getEmail());
            System.out.println("State = " + addressBook.getContact().getState());
            System.out.println("PhoneNumber = " + addressBook.getContact().getPhoneNumber());
            System.out.println("Zipcode = " + addressBook.getContact().getZipCode());
        });
    }

    void deleteRecord(){
        System.out.println("enter person first name for delete");
        Scanner in = new Scanner(System.in);
        String firstName = in.nextLine();
        AddressBook addressBook1 = AddressUtility.searchRecord(firstName, addressBooks);
        if (addressBook1 == null) {
            System.out.println("record not found");
            System.exit(0);
        }
        addressBooks.remove(addressBook1);
        System.out.println("record deleted");
        showRecord(addressBooks);
    }

    static void checkIfFirstNameDuplicate(Person person, Contact contact, List<AddressBook> addressBooks){
/*        addressBooks.stream().forEach(addressBook -> {

            if(addressBook.getPerson().getFirstName().equalsIgnoreCase(person.getFirstName())){
                System.out.println("address book allready present");
            }

        });*/

        AddressBook addressBook = new AddressBook();
        addressBook.setPerson(person);
        addressBook.setContact(contact);
        addressBooks.add(addressBook);
        MyObjectFileStore myObjectFileStore = new MyObjectFileStore();
        myObjectFileStore.storeObject(addressBook);
        myObjectFileStore.displayObjects();
        System.out.println("Record added in address book");
    }

    static AddressBook searchRecord(String firstName, List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            if(addressBook.getPerson().getFirstName().equals(firstName)){
                return addressBook;
            }
        }
        return null;
    }

    static AddressBook searchByCity(String city, List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            if(addressBook.getContact().getCity().equals(city)){
                return addressBook;
            }
        }
        return null;
    }

    static AddressBook searchByState(String state, List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            if(addressBook.getContact().getState().equals(state)){
                return addressBook;
            }
        }
        return null;
    }

    static AddressBook countByCity(String city, List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            if(addressBook.getContact().getCity().equals(city)){
                return addressBook;
            }
        }
        return null;
    }

    static AddressBook countByState(String state, List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            if(addressBook.getContact().getState().equals(state)){
                return addressBook;
            }
        }
        return null;
    }
}
