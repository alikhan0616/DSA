class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int index = 0;
        while (tickets[k] != 0){
            if(index == tickets.length) index = 0;
            if(tickets[index] == 0){
                index++;
            } else {
                tickets[index] = tickets[index] - 1;
                time++;
                index++;
            }
        }
        return time;
    }
}