class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> m = new HashMap<>();
        for (String word : strs){
            var wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String sorted = new String(wordArr);
            m.computeIfAbsent(sorted, (k) -> { 
                var list = new ArrayList<String>();
                return list;
            }).add(word);
        }
        return new ArrayList<>(m.values());
    }
}
