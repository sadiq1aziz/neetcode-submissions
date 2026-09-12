class Solution {
    public boolean isAnagram(String s, String t) {
        //use chars from stream api to perform lexical sorting
        String strS = s.chars().sorted().mapToObj((code) -> String.valueOf( (char)code )).collect(Collectors.joining());
        String strT = t.chars().sorted().mapToObj((code) -> String.valueOf( (char)code )).collect(Collectors.joining());
        if (strS.equals(strT)){
            return true;
        }
        return false;
    }
}
