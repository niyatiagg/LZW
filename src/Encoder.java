import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.*;

public class Encoder {
    public static void addToList(String str, Map<String, Integer> map, int[] size, List<Integer> list) {
        int i=0;
        while(i<str.length()) {
            int j=i;
            while(j < str.length() && map.containsKey(str.substring(i, j+1))) {
                j++;
            }
            list.add(map.get(str.substring(i, j)));
            if(j < str.length()) {
                map.put(str.substring(i, j+1), size[0]++);
            }
            i=j;
        }
    }
    public static List<Integer> encode(BufferedInputStream input) throws IOException {
        int[] size = new int[1];
        size[0] = 256;
        final Map<String, Integer> map = new HashMap();
        for(int i=0; i<size[0]; i++) {
            map.put(String.valueOf((char)i), i);
        }
        List<Integer> list = new ArrayList<>();
        byte[] arr = new byte[50];
        int ret = input.read(arr, 0, 50);
        String str;
        while (ret != -1) {
            if (ret > 0 && ret < 50) {
                StringBuilder sb = new StringBuilder(ret + 1);
                int i = 0;
                while (i < ret) {
                    sb.append(arr[i++]);
                }
                str = sb.toString();
            } else {
                str = String.valueOf(arr);
            }

            if (ret == 50) {
                addToList(str, map, size, list);
            }
            ret = input.read(arr, 0, 50);
        }



        return list;
    }
}
