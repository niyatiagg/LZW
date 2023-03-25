import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Encoder {
    public static List<Integer> encode(String str) {
        int size = 256;
        final Map<String, Integer> map = new HashMap();
        for(int i=0; i<size; i++) {
            map.put(String.valueOf((char)i), i);
        }
        final List<Integer> list = new LinkedList();
        int i=0;
        while(i<str.length()) {
            int j=i;
            while(j < str.length() && map.containsKey(str.substring(i, j+1))) {
                j++;
            }
            list.add(map.get(str.substring(i, j)));
            if(j < str.length()) {
                map.put(str.substring(i, j+1), size++);
            }
            i=j;
        }

        return list;
    }
}
