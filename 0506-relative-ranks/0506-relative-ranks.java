class Solution {
    public String[] findRelativeRanks(int[] score) {
        final int n=score.length;
        String a[]=new String[n];
        List<Integer>indices=new ArrayList<>();
        for(int i=0;i<n;++i)
            indices.add(i);
        Collections.sort(indices,(b,c)-> score[c]-score[b]);
        
        for(int i=0;i<n;++i)
            if(i==0)
                a[indices.get(0)]="Gold Medal";
        else if(i==1)
            a[indices.get(1)]="Silver Medal";
        else if(i==2)
            a[indices.get(2)]="Bronze Medal";
        else
            a[indices.get(i)]=String.valueOf(i+1);
        return a;
    }
}