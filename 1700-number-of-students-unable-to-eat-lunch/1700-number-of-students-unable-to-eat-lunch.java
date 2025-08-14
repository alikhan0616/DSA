class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circSandwiches = 0;
        int sqrSandwiches = 0;
        for(int choice : students){
            if(choice == 0){
                circSandwiches++;
            } else {
                sqrSandwiches++;
            }
        }
        for(int sandwich : sandwiches ){
            if(sandwich == 0 && circSandwiches == 0){
                return sqrSandwiches;
            } else if(sandwich == 1 && sqrSandwiches == 0){
                return circSandwiches;
            } else if(sandwich == 0){
                circSandwiches--;
            } else {
                sqrSandwiches--;
            }
        }
        return 0;
    }
}