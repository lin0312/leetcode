class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<Integer>(list));
        for(int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
