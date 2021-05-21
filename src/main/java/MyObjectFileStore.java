import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class MyObjectFileStore {
    public void storeObject(AddressBook addressBook){

        OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
            ops = new FileOutputStream("MyEmpFile.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(addressBook);
            objOps.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(objOps != null) objOps.close();
            } catch (Exception ex){

            }
        }
    }

    public void displayObjects(){
        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        try {
            fileIs = new FileInputStream("MyEmpFile.txt");
            objIs = new ObjectInputStream(fileIs);
            AddressBook addressBook = (AddressBook) objIs.readObject();
            System.out.println(addressBook.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objIs != null) objIs.close();
            } catch (Exception ex){

            }
        }
    }
}
