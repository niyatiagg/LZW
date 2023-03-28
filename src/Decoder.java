import java.io.IOException;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedOutputStream;

public class Decoder {
    public static void decode(List<Integer> list, BufferedOutputStream output) throws IOException {

        int size = 256;
        final Map<Integer, String> map = new HashMap();
        for(int i=0; i<size; i++) {
            map.put(i, String.valueOf((char)i));
        }

        byte[] arr = new byte[102400];
        int byteInd = 0;

        Integer old = list.get(0);
        StringBuilder sb = new StringBuilder(map.get(old));
        for(int j=0; j<sb.length(); j++) {
            arr[byteInd++] = (byte)sb.charAt(j);
        }
        int i;
        for(i=1; i<list.size(); i++) {
            Integer nEw = list.get(i);
            if(!map.containsKey(nEw)) {
                sb.append(sb.charAt(0));
            } else {
                sb = new StringBuilder(map.get(nEw));
            }

            for(int j=0; j<sb.length(); j++) {
                arr[byteInd++] = (byte)sb.charAt(j);
            }
            if(byteInd > 51200) {
                output.write(arr, 0, byteInd);
                byteInd = 0;
            }

            char c = sb.charAt(0);
            String st = map.get(old);
            map.put(size++, st.concat(String.valueOf(c)));
            old = nEw;
        }
        output.write(arr, 0, byteInd);
        output.close();

    }
}
