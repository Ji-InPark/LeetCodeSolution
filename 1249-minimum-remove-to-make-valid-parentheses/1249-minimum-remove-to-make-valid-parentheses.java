class Solution {
    public String minRemoveToMakeValid(String input) {
        String[] arr = input.split("");
        boolean[] valid = new boolean[arr.length];
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i].equals("("))
            {
                s.push(i);
            }
            else if(arr[i].equals(")"))
            {
                if(!s.isEmpty())
                    valid[i] = valid[s.pop()] = true;
            }
            else
            {
                valid[i] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++)
        {
            if(valid[i])
                sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}