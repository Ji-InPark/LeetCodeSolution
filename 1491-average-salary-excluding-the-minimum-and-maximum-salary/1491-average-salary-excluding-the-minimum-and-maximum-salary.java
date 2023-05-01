class Solution {
    public double average(int[] salary) {
        int max = salary[0], min = salary[0];
        double sum = 0;
        
        for(var s : salary) {
            sum += s;
            max = Math.max(max, s);
            min = Math.min(min, s);
        }
        
        return (sum - max - min) / (salary.length - 2);
    }
}