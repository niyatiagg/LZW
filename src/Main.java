import java.io.IOException;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.nio.file.*;
import java.nio.file.Paths;

public class Main {
    private static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));

    }

    private static void writeToFile(String fileName, String content) throws IOException {
        Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE);
    }

    public static void main(String[] args) throws IOException {

        String s = readFile("resources/input1");
        List<Integer> list = Encoder.encode(s); // Encoding the data in input file
        System.out.println(Arrays.toString(list.toArray()));
        String ans = Decoder.decode(list);
        writeToFile("resources/output", ans); // Decoding the data to a new file output
        System.out.println(ans);
    }
}

