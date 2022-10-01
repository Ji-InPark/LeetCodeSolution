class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for(int i=0;i<buildings.length;i++){
            height.add(new int[]{buildings[i][0], -buildings[i][2]});
            height.add(new int[]{buildings[i][1], buildings[i][2]});
        }

        Collections.sort(height,(a,b)->(a[0]==b[0])?(a[1]-b[1]):(a[0]-b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int pre = 0;

        for(int[] h: height){
            if(h[1]<0){
                pq.add(-h[1]);
            } else {
                pq.remove(h[1]);
            }

            if(pre!=pq.peek()){
                List<Integer> tempans = new ArrayList<>();
                tempans.add(h[0]);
                tempans.add(pq.peek());
                ans.add(tempans);
            }
            
            pre = pq.peek();
        }

        return ans;
    }
}