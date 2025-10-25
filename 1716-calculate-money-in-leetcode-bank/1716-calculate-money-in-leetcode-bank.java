class Solution {
    public int totalMoney(int n) {
        int count = 1;
        int days = 1;
        int mondayCount = 1; 
        int res = 0;
        while(n > 0){
            if(days > 7){
                mondayCount++;
                count = mondayCount;
                days = 1;
            }
            res += count;
            count++;
            days++;
            n--;
        }
        return res;
    }
}