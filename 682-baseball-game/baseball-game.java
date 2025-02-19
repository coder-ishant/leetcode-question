class Solution {
    public int calPoints(String[] operations) {
        int sum=0;
        ArrayList<Integer> arr=new ArrayList<>();
        for (String op : operations) {
            if (op.equals("+")) {
                int last = arr.get(arr.size() - 1);
                int secondLast = arr.get(arr.size() - 2);
                arr.add(last + secondLast);
            } else if (op.equals("D")) {
                arr.add(2 * arr.get(arr.size() - 1));
            } else if (op.equals("C")) {
                arr.remove(arr.size() - 1);
            } else {
                arr.add(Integer.parseInt(op));
            }
        }

        for (int score : arr) {
            sum += score;
        }
        
        return sum;
    }
}