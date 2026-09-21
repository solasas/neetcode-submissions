class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        List<Integer>[] bucket=new ArrayList[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num: map.keySet()){
            int freq=map.get(num);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        int[] ans=new int[k];
        int idx=0;
        for(int i=n;i>=0;i--){
            if(bucket[i]!=null){
                for(int num : bucket[i]){
                    ans[idx++]=num;
                    if(idx==k){
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}
