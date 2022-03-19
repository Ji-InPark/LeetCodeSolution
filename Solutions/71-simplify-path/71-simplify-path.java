class Solution {
    public String simplifyPath(String path) {
        ArrayList<String> arr = new ArrayList<String>();
        String[] input = path.split("/");

        for(int i = 0; i < input.length; i++)
        {
            if(input[i].equals("."))
                continue;
            else if(input[i].equals(".."))
            {
                if(arr.size() > 0)
                    arr.remove(arr.size() - 1);
            }
            else if(input[i].equals(""))
                continue;
            else
                arr.add(input[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < arr.size(); i++)
        {
            sb.append("/");
            sb.append(arr.get(i));
        }
        
        if(sb.length() == 0)
            sb.append("/");
        
        return sb.toString();
    }
}