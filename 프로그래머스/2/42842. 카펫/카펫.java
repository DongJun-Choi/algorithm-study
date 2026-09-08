class Solution {
    public int[] solution(int brown, int yellow) {        
        int sum = (brown + 4) / 2;
        
        int h = sum / 2;
        int w = sum - h;
        
        while (h >= 3) {
            if ((w - 2) * (h - 2) == yellow) {
                return new int[]{w, h};
            }

            w++;
            h--;
        }

        return null;
    }
}