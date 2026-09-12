class Solution {
    public boolean isAnagram(String s, String t) {
        
        String str = s.chars()
        .sorted()
        .mapToObj((item) -> String.valueOf(item))
        .collect(Collectors.joining());

        String str1 = t.chars()
        .sorted()
        .mapToObj((item) -> String.valueOf(item))
        .collect(Collectors.joining());

        return str.equalsIgnoreCase(str1);
    }
}
