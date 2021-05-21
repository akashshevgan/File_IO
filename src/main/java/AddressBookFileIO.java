import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class AddressBookFileIO {

    public static String FILE_NAME = "addressBook.txt";

    public void writeDataToFile(List<AddressBook> addressBooks) {
        StringBuffer buffer = new StringBuffer();
        addressBooks.forEach(details -> {
            String personDetailsString = details.toString().concat("\n");
            System.out.println(personDetailsString+ "data");
            buffer.append(personDetailsString);
        });

        try {
            Files.write(Paths.get(FILE_NAME), buffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            Files.lines(new File("addressBook.txt").toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countList() {
        long count = 0;
        try {
            count = Files.lines(new File("addressBook.txt").toPath())
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        AddressBookFileIO io = new AddressBookFileIO();
        AddressBook[] contacts = {
                new AddressBook(),
        };
        io.writeDataToFile(Arrays.asList(contacts));
        io.readData();
        io.countList();
    }
}
