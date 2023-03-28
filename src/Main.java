import java.io.*;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;


public class Main {
    public static void main(String[] args) throws IOException {
        // Creates a FileInputStream
        FileInputStream file = new FileInputStream("resources/input1");

        // Creates a BufferedInputStream
        BufferedInputStream input = new BufferedInputStream(file);
        List<Integer> list = Encoder.encode(input); // Encoding the data in input file

        // Creates a FileOutputStream
        FileOutputStream newFile = new FileOutputStream("resources/output");

        // Creates a BufferedOutputStream
        BufferedOutputStream output = new BufferedOutputStream(newFile);
        Decoder.decode(list, output);
    }
}

