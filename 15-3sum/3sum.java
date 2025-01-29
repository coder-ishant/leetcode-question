class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listofList=new ArrayList<List<Integer>>();
        ArrayList<Integer> list;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1,k=n-1;
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    //Collections.sort(list);
                    listofList.add(list);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }

                }
            }
                
                 
            
        }
         //listofList.add(list);
        return listofList;
    }
}