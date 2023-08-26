class Solution {
    static int y = 0;
    static int x = 0;
    
    public int[] solution(String[] park, String[] routes) {
        
        for(int i = 0; i < park.length; i++) {
            int index = park[i].indexOf("S");
            if(index != -1) {
                x = index;
                y = i;
                break;
            }
        }
        
        for(String s : routes) {
            char direction = s.charAt(0);
            int distance = s.charAt(2) - '0';
            
            System.out.println("y : " + y + " x : " + x);
            
            switch(direction) {
                case 'E' : x = checkX(park, distance); break;
                case 'W' : x = checkX(park, distance * - 1); break;
                case 'S' : y = checkY(park, distance); break;
                case 'N' : y = checkY(park, distance * - 1); break;
            }
        }
        
        return new int[]{y, x};
    }
    
    static public int checkX(String[] park, int distance) {
        
        if (x + distance >= park[0].length() || x + distance < 0) return x;
        
        for(int i = x; i != x + distance;) {

            int nextX = distance > 0 ? i + 1 : i - 1;
                
            if (park[y].charAt(nextX) == 'X') return x;
            
            i = distance > 0 ? ++i : --i;
        }
        
        return x + distance;
    }
    
    static public int checkY(String[] park, int distance) {
        
        if (y + distance >= park.length || y + distance < 0) return y;
        
        for(int i = y; i != y + distance;) {
            
            int nextY = distance > 0 ? i + 1 : i - 1;
            
            if (park[nextY].charAt(x) == 'X') return y;
            
            i = distance > 0 ? ++i : --i;
        }
        
        return y + distance;
    }
}