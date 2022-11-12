public class Circle {
    public static void main(String[] args) {
        int[] n = {1,2,3,4};
        for(int b=0;b<n.length;b++) {
            System.out.print(n[b]+" ");
        }
        for(int i=0;i<n.length-1;i++) {
            int temp = n[n.length-1];
            for(int k=n.length-1;k>0;k--) {
                n[k] = n[k-1];
            }
            n[0] = temp;
            System.out.println();
            for(int j=0;j<n.length;j++) {
                System.out.print(n[j]+" ");
            }
        }
    }
}
