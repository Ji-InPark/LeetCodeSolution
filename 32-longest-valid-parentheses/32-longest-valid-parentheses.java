class Solution {
    public int longestValidParentheses(String input) {
        int result = 0;
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<pair> arr = new ArrayList<pair>();
        
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == '(')
            {
                s.push(i);
            }
            else
            {
                if(s.isEmpty())
                {
                    continue;
                }
                else
                {
                    int nowFirst = s.pop();
                    arr.add(new pair(nowFirst, i));
                }
            }
        }
        
        Collections.sort(arr);
        
        for(int i = 0; i < arr.size() - 1; i++)
        {
            result = Math.max(result, arr.get(i).last - arr.get(i).first + 1);
            
            pair temp1 = arr.get(i);
            pair temp2 = arr.get(i + 1);
            
            if(temp1.last == temp2.first - 1)
            {
                arr.get(i).last = temp2.last;
                arr.remove(i + 1);
                i--;
            }
            else if(temp1.first < temp2.first && temp2.last < temp1.last)
            {
                arr.remove(i + 1);
                i--;
            }
        }
        
        if(arr.size() != 0)
            result = Math.max(result, arr.get(arr.size() - 1).last - arr.get(arr.size() - 1).first + 1);
        
        return result;
    }
    
    class pair implements Comparable<pair>
    {
        int first, last;
        public pair(int first, int last)
        {
            this.first = first;
            this.last = last;
        }
        
        @Override
        public int compareTo(pair p) 
        {
            return this.first - p.first;
        }
    }
}