class Solution {
    class Pair{
        String word;
        int step;
        Pair(String word,int step){
            this.word=word;
            this.step=step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<len;i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        Queue<Pair> q =new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair curr= q.poll();
            String currWord=curr.word;
            int s=curr.step;

            if(currWord.equals(endWord)) return s;

            for(int i =0 ;i<currWord.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char [] array=currWord.toCharArray();
                    array[i]=ch;
                    String wd= new String(array); 
                    if(set.contains(wd)){
                        set.remove(wd);
                        q.offer(new Pair(wd,s+1));
                    }
                }
            }
        }
        return 0;
    }
}