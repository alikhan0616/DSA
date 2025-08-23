class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxProfit = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int i = 0 ; i < capital.length ; i++){
            minCapital.add(new int[]{capital[i], profits[i]});
        }

        for(int i = 0  ; i < k ; i++){

            while(!minCapital.isEmpty() && minCapital.peek()[0] <= w){
                maxProfit.add(minCapital.poll());
            }

            if(maxProfit.isEmpty()){
                break;
            }

            w += maxProfit.poll()[1];
        }
        return w;
    }
}