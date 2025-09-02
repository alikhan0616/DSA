class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] candi, int target,  List<List<Integer>> res,
    List<Integer> curr, int pos){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0){
            return;
        }

        int prev = -1;
        for(int i = pos; i < candi.length; i++){
            if(prev == candi[i]) continue;
            curr.add(candi[i]);
            backtrack(candi, target - candi[i], res, curr, i + 1);
            curr.remove(curr.size() - 1);
            prev = candi[i];
        }
    }
}