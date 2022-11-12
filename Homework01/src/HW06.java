//打印出1~1000之间的所有质数

public class HW06 {
    public static void main(String[] args) {
        for(int i=2;i<=1000;i++){
            if(isPrime(i))
                System.out.println(i);
        }
    }

    public static boolean isPrime(int index){
        for(int i=2;i<=Math.floor(Math.sqrt(index));i++){
            if(index%i==0)
                return false;
        }
        return true;
    }
}


