class Solution {
    public int maxArea(int[] height) {
        int i=0,area=0;
        int j=height.length-1;
        while(i<j){
            int a=Math.min(height[i],height[j]);
            area=Math.max(area,a*(j-i));
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return area;
}
}