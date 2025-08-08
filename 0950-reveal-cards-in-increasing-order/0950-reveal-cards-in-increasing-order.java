class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < deck.length ; i++){
            q.offer(i);
        }
       int[] result = new int[deck.length];
       for(int i = 0 ; i < deck.length ; i++){
           result[q.poll()] = deck[i];
           if(!q.isEmpty()){
            q.offer(q.peek());
            q.poll();
           }
       }
        return result;
    }

}