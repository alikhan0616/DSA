class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> available  = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            available.offer(i);
        }

        PriorityQueue<long []> used = new PriorityQueue<>((a , b) -> a[0] == b[0] ?
        Long.compare(a[1] , b[1]) :
        Long.compare(a[0] , b[0]));

        int[] count = new int[n];

        for(int[] meeting : meetings){
            long start = meeting[0];
            long end =  meeting[1];

            // Check for any finished up meeting before start time of current one
            while(!used.isEmpty() && used.peek()[0] <= start){
                long[] finished = used.poll();
                available.offer((int) finished[1]);
            }

            // If rooms are full check of avaiable earliest room
            if(available.isEmpty()){
                long[] earliest = used.poll();
                long endTime = earliest[0];
                end = (endTime + (end - start));
                available.offer((int) earliest[1]); 
            }

            // Simply Schedule the meeting
            int room = available.poll();
            used.offer(new long[]{end, room});
            count[room]++;
        }

        int ans = 0;
        for(int i = 1 ; i < n ; i++){
            if(count[i] > count[ans]){
                ans = i;
            }
        }
        return ans;
    }
}