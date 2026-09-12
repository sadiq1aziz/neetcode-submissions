class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //create an array of arrays wherein each element is a tuple
        //sort based on position
        int [][] temp = IntStream.range(0, position.length)
            .mapToObj((i) -> new int[]{position[i], speed[i]})
            .sorted((a, b) -> b[0] - a[0])
            .toArray(int [][] :: new);


        //create an array of time in double
        double [] times  = IntStream.range(0, speed.length)
            .mapToDouble((i) -> (double) (target - temp[i][0]) / temp[i][1])
            .toArray();

        int fleets = 0;
        double leadTime = 0;
        for ( double time : times ){
            if ( time > leadTime ){
                leadTime = time;
                fleets++;
            }
        }

        return fleets;
    }
}
