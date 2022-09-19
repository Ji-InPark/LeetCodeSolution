class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String path : paths) {
            String[] arr = path.split(" ");
            String root = arr[0];
            
            for(int i = 1; i < arr.length; i++) {
                String[] pathAndContent = arr[i].replaceAll("\\((.*?)\\)", " $1").split(" ");
                String p = pathAndContent[0], c = pathAndContent[1];
                if(!map.containsKey(c)) map.put(c, new ArrayList<>());
                map.get(c).add(root + "/" + p);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if(entry.getValue().size() > 1) result.add(entry.getValue());
        }
        
        return result;
    }
}