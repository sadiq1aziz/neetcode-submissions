class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //create map to track word subsets
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++ ){
            char[] wordArray = strs[i].toCharArray();
            //covert char arr to string
            Arrays.sort(wordArray);
            String s = new String(wordArray);
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(strs[i]);
        }

        //rather than use an entry set, just dump the values from the map 
        //into a new instantiation
        return new ArrayList<>(map.values());
    }
}
