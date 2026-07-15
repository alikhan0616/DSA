class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0 ; i < numbers.length ; i++){
            int l = i + 1, r = numbers.length - 1;
            int temp = target - numbers[i];
            while(l <= r){
                int mid = (l + r) / 2;
                if(numbers[mid] == temp) return new int[]{i + 1, mid + 1};
                if(numbers[mid] > temp){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
            return new int[]{};
    }
}