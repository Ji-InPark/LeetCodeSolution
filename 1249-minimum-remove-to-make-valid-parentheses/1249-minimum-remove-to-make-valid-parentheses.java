class Solution {
    public String minRemoveToMakeValid(String input) {
        char[] arr = input.toCharArray();
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == '(')
            {
                s.push(i);
                arr[i] = ' ';
            }
            else if(arr[i] == ')')
            {
                if(!s.isEmpty())
                    arr[s.pop()] = '(';
                else
                    arr[i] = ' ';
            }
        }
        
        
        return new String(arr).replaceAll(" ", "");
    }
}