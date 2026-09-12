class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] res = new int[k];
        //use strean api
        Map<Integer, Long> map = Arrays.stream(nums)
        .boxed()
        .collect(Collectors
        .groupingBy((item) -> item, Collectors.counting()));
    
        //Use priority queue to sort based on increasing frequency
        Queue<Map.Entry<Integer, Long>> pq = new PriorityQueue<>((a, b) -> 
            Long.compare(b.getValue(), a.getValue()));

        pq.addAll(map.entrySet());     
        int count = 0;
        while (count < k){
            res[count] = pq.poll().getKey();
            count++;
        }
        return res;
    }
}
