class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> radiants = new ArrayDeque<>();
        Deque<Integer> dires = new ArrayDeque<>();
        int n = senate.length();
        for(int i = 0 ; i < n ; i++){
            if(senate.charAt(i) == 'R'){
                radiants.offer(i);
            } else {
                dires.offer(i);
            }
        }
        while(!radiants.isEmpty() && !dires.isEmpty()){
            if(radiants.peek() < dires.peek()){
                radiants.offer(n++);
            } else {
                dires.offer(n++);
            }
            radiants.poll();
            dires.poll();
        }
        return radiants.isEmpty() ? "Dire" : "Radiant";
    }
}