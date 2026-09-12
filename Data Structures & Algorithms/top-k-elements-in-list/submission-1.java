class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //1.count freq -> returns map with item and count via stream
        //2.sort based on freq -> use PQ
        int [] res = new int[k];

        Map<Integer, Long> map = Arrays.stream(nums)
        //convert from primitive to wrappers
        .boxed()
        .collect(Collectors.groupingBy( (item) -> item, Collectors.counting()));

        //pass in the comparator function 
        PriorityQueue<Map.Entry<Integer, Long>> pq = new PriorityQueue<>((a, b) -> Long
        .compare(b.getValue(), a.getValue()));


        pq.addAll(map.entrySet());

        //Poll the pq for k times
        int count = 0;        
        while ( count < k ){
            res[count] = pq.poll().getKey();
            count++;
        }
        return res;
    }
}
