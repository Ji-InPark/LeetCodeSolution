class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(var candy: candies) max = Math.max(max, candy);
        
        var result = new ArrayList<Boolean>();
        for(var candy: candies) result.add(candy + extraCandies >= max);
        
        return result;
    }
}