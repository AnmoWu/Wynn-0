public class AnDian {
    public static void main(String[] args)
    {
        int a[][] = {{3,1,2},{0,0,1}};
        int min,x,flag;
        min = a[0][0]; x = 0; flag = 0;
        for(int i=0;i<a.length;i++){
            min = a[i][0];flag = 0;x = 0;
            for(int j=0;j<a[i].length;j++){
                if(min>a[i][j]){
                    min = a[i][j];
                    x = j;
                }
            }
            for(int b=0;b<a.length;b++){
                if(min<a[b][x]){
                    flag=1;
                }
            }
            if(flag==0){
                System.out.println("马鞍点为：第"+(i+1)+"行，第"+(x+1)+"列"+a[i][x]);
            }
        }
    }
}
