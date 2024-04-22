class Solution {
    public int openLock(String[] deadends, String target) {
    
    Set<String> mi = new HashSet<>(Arrays.asList(deadends));
    if (mi.contains("0000"))
      return -1;
    if (target.equals("0000"))
      return 0;

    int ans = 0;
    Queue<String> im = new ArrayDeque<>(Arrays.asList("0000"));

    while (!im.isEmpty()) {
      ++ans;
      for (int sz = im.size(); sz > 0; --sz) {
        StringBuilder sb = new StringBuilder(im.poll());
        for (int i = 0; i < 4; ++i) {
          final char cache = sb.charAt(i);
          // Increase the i-th digit by 1.
          sb.setCharAt(i, sb.charAt(i) == '9' ? '0' : (char) (sb.charAt(i) + 1));
          String word = sb.toString();
          if (word.equals(target))
            return ans;
          if (!mi.contains(word)) {
            im.offer(word);
            mi.add(word);
          }
          sb.setCharAt(i, cache);
          // Decrease the i-th digit by 1.
          sb.setCharAt(i, sb.charAt(i) == '0' ? '9' : (char) (sb.charAt(i) - 1));
          word = sb.toString();
          if (word.equals(target))
            return ans;
          if (!mi.contains(word)) {
            im.offer(word);
            mi.add(word);
          }
          sb.setCharAt(i, cache);
        }
      }
    }

    return -1;
  }
}
    