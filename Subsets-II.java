//DFS
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int pos) {
        if(!res.contains(list)) {
            res.add(new ArrayList<Integer>(list));
        }
        for(int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
