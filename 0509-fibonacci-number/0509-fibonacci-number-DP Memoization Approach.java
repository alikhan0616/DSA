class Solution {
    Map<Integer, Integer> hm = new HashMap<>();
    int result;
    public int fib(int n) {
        if(hm.containsKey(n)) return hm.get(n);
        if(n == 0) return 0;
        if(n <= 2){
            return 1;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }

        hm.put(n , result);
        return result;
    }
}