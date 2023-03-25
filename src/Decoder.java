import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Decoder {
    public static String decode(List<Integer> list) {
        int size = 256;
        final Map<Integer, String> map = new HashMap();
        for(int i=0; i<size; i++) {
            map.put(i, String.valueOf((char)i));
        }
        StringBuilder sb = new StringBuilder();

        Integer old = list.get(0);
        String s = map.get(old);
        sb.append(s);
        for(int i=1; i<list.size(); i++) {
            Integer nEw = list.get(i);
            if(!map.containsKey(nEw)) {
                char ch = s.charAt(0);
                s = s.concat(String.valueOf(ch));
            }
            else {
                s = map.get(nEw);
            }
            sb.append(s);
            char c = s.charAt(0);
            String st = map.get(old);
            map.put(size++, st.concat(String.valueOf(c)));
            old = nEw;
        }

        return sb.toString();
    }
}
