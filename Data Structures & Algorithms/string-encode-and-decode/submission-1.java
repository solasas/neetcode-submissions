class Solution {

    public String encode(List<String> strs) {
         StringBuilder sb=new StringBuilder();
         for(String str : strs){
            //including some delimeter for handling edge cases
            sb.append(str.length()).append('#').append(str);
         }
         return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodes=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int sepIdx=str.indexOf("#",i);
            int len=Integer.parseInt(str.substring(i, sepIdx));
            String curr=str.substring(sepIdx+1,sepIdx+1+len);
            decodes.add(curr);
            i=sepIdx+1+len;
        }
        return decodes;
    }
}
