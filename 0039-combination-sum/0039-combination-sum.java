class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
    private void findCombinations(int index, int target, int[] array, List<List<Integer>> ans, List<Integer> ds){
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(index == array.length) return;
        if(array[index] <= target){
            ds.add(array[index]);
            findCombinations(index, target - array[index], array, ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(index + 1, target, array, ans, ds);
    }
}