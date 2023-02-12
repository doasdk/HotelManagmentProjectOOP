package pl.edu.amu.wmi.s474155;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataWriter {
        public void dataWriter(Hotel hotel) throws IOException {


                FileOutputStream fileOutputStream = new FileOutputStream("K:\\uam\\programowanie obiektowe\\test.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(hotel);

                objectOutputStream.flush();

                objectOutputStream.close();
                fileOutputStream.close();
        }
}
