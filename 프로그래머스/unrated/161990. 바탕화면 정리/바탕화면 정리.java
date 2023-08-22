class Solution {
    public int[] solution(String[] wallpaper) {
        
        // 가장 위의 #, 가장 왼쪽 #, 가장 밑의 #, 가장 오른쪽의 #

        int wallpaperLength = wallpaper.length;
        
        int lux = wallpaperLength;
        int luy = wallpaper[0].length();
        int rdx = 0;
        int rdy = 0;
        
        for(int i = 0; i < wallpaperLength; i++) {
            
            String element = wallpaper[i];
            
            if(element.contains("#")) {
                if(lux > i) {
                    lux = i;
                }
                if (rdx < i) {
                    rdx = i;
                }
                
                for(int j = 0; j < element.length(); j++) {
                    
                    char oneElement = element.charAt(j);
                    
                    if(oneElement == '#' && luy > j) {
                        luy = j;
                    }
                    if (oneElement == '#' && rdy < j) {
                        rdy = j;
                    }
                }
            }
        }
        
        int[] answer = {lux, luy, rdx + 1, rdy + 1};
        
        return answer;
    }
}