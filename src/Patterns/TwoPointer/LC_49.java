package Patterns.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){

            String str = strs[i];

            char[] arr = str.toCharArray();

            Arrays.sort(arr);

            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);

        }

        List<List<String>> ans = new ArrayList<>( map.values());

        return ans;
    }
}
