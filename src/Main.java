import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        String s = "MorelMorelMorelMorelMorel";
        List<Integer> list = Encoder.encode(s);
        System.out.println(Arrays.toString(list.toArray()));
        String ans = Decoder.decode(list);
        System.out.println(ans);
    }
}

