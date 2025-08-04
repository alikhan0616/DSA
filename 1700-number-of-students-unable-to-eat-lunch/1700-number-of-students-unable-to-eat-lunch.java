class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> q = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i < students.length ; i++){
            q.offerLast(students[i]);
        }
        for(int i  = sandwiches.length - 1; i >= 0 ; i--){
            s.push(sandwiches[i]);
        }
        int count = 0;
        while(!q.isEmpty() || !s.isEmpty()){
            if(q.peekFirst() == s.peek()){
                s.pop();
                q.pollFirst();
                count = 0;
            } else {
                q.offerFirst(q.getLast());
                q.pollLast();
                count++;
            } 
            if(count >= q.size()) break;
        }
        return q.size();
    }
}