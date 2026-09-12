class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //create an array of pos speed
        int [][] temp = IntStream.range(0, position.length)
        .mapToObj((i) -> new int[]{position[i], speed[i]})
        .sorted( (a, b) -> b[0] - a[0]).toArray(int[][] :: new);


        //get times
        double [] times  = IntStream.range(0, speed.length)
        .mapToDouble((i) -> (double)(target - temp[i][0])/temp[i][1]).toArray();


        //calculate fleets and lead time
        double leadTime = 0;
        int fleets = 0;
        //iterate through times
        for (double i : times){
            if ( i > leadTime){
                fleets++;
                leadTime = i;
            }
        }
        return fleets;
    }
}
