class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> perm){
        if(perm.size() == nums.length){
            result.add(new ArrayList<>(perm));
            return;
        }

        for(int num : nums){
            if(perm.contains(num)){
                continue;
            }
            perm.add(num);
            backtrack(result, nums, perm);
            perm.remove(perm.size() - 1);
        }
    }
}