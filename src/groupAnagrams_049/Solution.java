package groupAnagrams_049;

import com.sun.deploy.security.SelectableSecurityManager;
import javafx.collections.transformation.SortedList;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*
    Given an array of strings, group anagrams together.

    Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
 */
public class Solution {

    /*
        利用map，将每个string排序后的字符串作为key，该字符集对应的字符串的list作为value，例如ate与eat排序后的字符数组为aet，若map
        中已经出现aet作为的key，则将其对应的string添加到此key的value中
     */
    public List<List<String>> groupAnagrams(String[] strs){
//        Arrays.sort(strs);
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            if(!map.containsKey(String.valueOf(charArray))){
                map.put(String.valueOf(charArray), new ArrayList<>());
            }
            map.get(String.valueOf(charArray)).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    @Test
    public void test(){
        String[] input = new String[]{"paw","dad","bog","day","day","mig","len","rat"};
        List<List<String>> excepted = new ArrayList<>();
        excepted.add(Arrays.asList("ate","eat","tea"));
        excepted.add(Arrays.asList("nat","tan"));
        excepted.add(Arrays.asList("bat"));
        assertEquals(excepted, new Solution().groupAnagrams(input));
//        assertEquals(false, new Solution().isGroup("dad", "day"));
    }
}
