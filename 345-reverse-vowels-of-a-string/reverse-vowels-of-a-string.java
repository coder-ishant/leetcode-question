class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a','e','i','o','u','A','E','I','O','U'
        ));
        int i=0;
        int j=s.length()-1;
        char[] chars = s.toCharArray();
        while(i<j){
            while(i<j && !vowels.contains(chars[i])){
                i++;
            }
            while(i<j && !vowels.contains(chars[j])){
                j--;
            }
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}