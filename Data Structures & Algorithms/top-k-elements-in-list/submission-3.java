class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

    return Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(key -> key, Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Comparator.comparing(Map.Entry<Integer, Long>::getValue).reversed())
        .mapToInt(e -> e.getKey())
        .limit(k)
        .toArray();
    }
}
