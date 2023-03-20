class Solution {
    public String solution(String letter) {
        String[] arr = letter.split(" ");
        
        for(int i = 0; i < arr.length; i++) {
            switch(arr[i]){
                case ".-" : 
                    arr[i] = arr[i] = "a"; break;
                case "-..." : arr[i] = "b"; break;
                case "-.-." : arr[i] = "c"; break;
                case "-.." : arr[i] = "d"; break;
                case "." : arr[i] = "e"; break;
                case "..-." : arr[i] = "f"; break;
                case "--." : arr[i] = "g"; break;
                case "...." : arr[i] = "h"; break;
                case ".." : arr[i] = "i"; break;
                case ".---" : arr[i] = "j"; break;
                case "-.-" : arr[i] = "k"; break;
                case ".-.." : arr[i] = "l"; break;
                case "--" : arr[i] = "m"; break;
                case "-." : arr[i] = "n"; break;
                case "---" : arr[i] = "o"; break;
                case ".--." : arr[i] = "p"; break;
                case "--.-" : arr[i] = "q"; break;
                case ".-." : arr[i] = "r"; break;
                case "..." : arr[i] = "s"; break;
                case "-" : arr[i] = "t"; break;
                case "..-" : arr[i] = "u"; break;
                case "...-" : arr[i] = "v"; break;
                case ".--" : arr[i] = "w"; break;
                case "-..-" : arr[i] = "x"; break;
                case "-.--" : arr[i] = "y"; break;
                case "--.." : arr[i] = "z"; break;
            }
        }
        return String.join("", arr);
    }
}