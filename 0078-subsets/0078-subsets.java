class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=  new ArrayList<>();

        dfs(0, result, new ArrayList<>(),  nums);
        return result;
    }

    private void dfs(int idx, List<List<Integer>> result, List<Integer> subset, int[] nums){
        if(idx >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        dfs(idx + 1, result, subset, nums);
        subset.remove(subset.size() - 1);

        dfs(idx + 1, result, subset, nums);
    }
}