package common_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs){
		if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
	}
	
	public List<List<String>> groupAnagramsFaster(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        Map<String, Integer> map = new HashMap<>(); // String to index in res
        for (String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String unique = new String(c);
            Integer idx = map.get(unique);
            
            if (idx == null) {
                map.put(unique, map.size());
                List<String> anotherRow = new ArrayList<>();
                anotherRow.add(s);
                res.add(anotherRow);
            } else {
                res.get(idx).add(s);
            }
        }
        return res;
    }
}
