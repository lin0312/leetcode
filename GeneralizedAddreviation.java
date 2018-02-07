class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if(word == null || word.length() == 0) {
            res.add("");
            return res;
        }
        backtrack(word, res, 0, 0, "");
        return res;
    }
    private void backtrack(String word, List<String> res, int pos, int count, String str) {
        if(pos == word.length()) {
            if(count > 0) {
                str += count;
            }
            res.add(str);
            return;
        }
        backtrack(word, res, pos + 1, count + 1, str);
        backtrack(word, res, pos + 1, 0, str + (count > 0 ? count : "") + word.charAt(pos));
    }
}
