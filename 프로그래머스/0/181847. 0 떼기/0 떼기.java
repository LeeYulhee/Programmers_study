class Solution {
    public String solution(String n_str) {        
        return n_str.indexOf("0") == 0 ? n_str.replaceFirst("0+", "") : n_str;
    }
}