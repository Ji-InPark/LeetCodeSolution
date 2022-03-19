class Solution {
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    HashMap<String, Boolean> visit = new HashMap<String, Boolean>();
    
    String end;
    
    int result = 10000;
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayList temp;
        
        end = endWord;
        
        map.put(beginWord, new ArrayList<String>());
        visit.put(beginWord, false);
        
        boolean hasEnd = false;
        for(int i = 0; i < wordList.size(); i++)
        {
            map.put(wordList.get(i), new ArrayList<String>());
            visit.put(wordList.get(i), false);
            
            if(check(beginWord, wordList.get(i)))
            {
                temp = map.get(beginWord);
                temp.add(wordList.get(i));
                map.put(beginWord, temp);
            }
            
            if(wordList.get(i).equals(endWord))
                hasEnd = true;
        }
        
        if(!hasEnd)
            return 0;
        
        for(int i = 0; i < wordList.size(); i++)
        {
            if(wordList.get(i).equals(beginWord))
                continue;
            
            for(int j = i + 1; j < wordList.size(); j++)
            {
                if(check(wordList.get(i), wordList.get(j)))
                {
                    temp = map.get(wordList.get(i));
                    temp.add(wordList.get(j));
                    map.put(wordList.get(i), temp);
                    
                    temp = map.get(wordList.get(j));
                    temp.add(wordList.get(i));
                    map.put(wordList.get(j), temp);
                }
            }
        }
        
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        
        solve(q, 1);
        
        return result == 10000 ? 0 : result;
    }
    
    public void solve(Queue<String> q, int level)
    {
        Queue<String> next = new LinkedList<String>();
        ArrayList<String> arr;
        
        while(!q.isEmpty())
        {
            arr = map.get(q.poll());
            
            for(int i = 0; i < arr.size(); i++)
            {
                if(!visit.get(arr.get(i)))
                {
                    visit.put(arr.get(i), true);
                    next.add(arr.get(i));
                }
                
                if(arr.get(i).equals(end))
                {
                    result = level + 1;
                    return;
                }
            }
        }
        
        if(!next.isEmpty())
            solve(next, level + 1);
    }
    
    public boolean check(String s1, String s2)
    {
        if(s1.length() != s2.length())
            return false;
        
        int diff = 0;
        
        for(int i = 0; i < s1.length(); i++)
        {
            if(s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        
        return diff == 1;
    }
}