class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, String> map = new HashMap<String, String>();
        List<String> result = new ArrayList<String>();
        
        for(String sup : supplies)
            map.put(sup, sup);
        
        boolean flag = true;
        
        while(flag)
        {
            flag = false;
            for(int i = 0; i < recipes.length; i++)
            {
                boolean isMade = true;
                for(int j = 0; j < ingredients.get(i).size(); j++)
                {
                    if(!map.containsKey(ingredients.get(i).get(j)))
                       isMade = false;
                }
                if(isMade && !map.containsKey(recipes[i]))
                {
                    map.put(recipes[i], "");
                    result.add(recipes[i]);
                    flag = true;
                }
            }
        }
        
        return result;
    }
}