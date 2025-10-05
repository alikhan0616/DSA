class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            graph.get(i[1]).add(i[0]);
            inDegree[i[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;
        for(int i = 0  ; i < numCourses ; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            result[index] = curr;
            index++;
            for(int next : graph.get(curr)){
                inDegree[next]--;
                if(inDegree[next] == 0) q.offer(next);
            }
        }

        if(numCourses == index) return result;
        return new int[]{};
    }
}