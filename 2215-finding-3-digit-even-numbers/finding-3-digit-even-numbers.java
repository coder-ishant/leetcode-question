class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> arr=new ArrayList<>();
        int[] map=new int[10];
        for(int i=0;i<digits.length;i++){
            map[digits[i]]++;
        }
        for(int i=1;i<=9;i++){
            if(map[i]==0) continue;
            map[i]--;
            for(int j=0;j<=9;j++){
                if(map[j]==0) continue;
                map[j]--;
                for(int k=0;k<=8;k+=2){
                    if(map[k]==0) continue;
                    map[k]--;
                         int num=i*100+j*10+k*1;
                        arr.add(num);
                    map[k]++;

                }
                map[j]++;
            }
            map[i]++;
            
        }
        int[] ans=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}