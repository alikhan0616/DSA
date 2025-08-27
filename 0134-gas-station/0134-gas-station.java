class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int n = cost.length;
        for(int i = 0 ; i < n ; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalCost > totalGas){
            return -1;
        }

        int startIndex = 0, currentGas = 0;
        for(int i = 0 ; i < n ; i++){
            currentGas += gas[i] - cost[i];

            if(currentGas < 0){
                startIndex = i + 1;
                currentGas = 0;
            }
        }
        return startIndex;
    }
}