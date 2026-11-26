class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        Queue<String> qu = new LinkedList<>();
        qu.add(beginWord);
        int steps = 1;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                String word = qu.poll();
                if (word.equals(endWord)) {
                    return steps;
                }
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String next = new String(chars);
                        if (words.contains(next)) {
                            qu.add(next);
                            words.remove(next);
                        }
                    }
                    chars[j] = original;

                }

            }
            steps++;
        }
        return 0;
    }
}