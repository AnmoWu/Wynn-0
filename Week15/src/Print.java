public class Print {
    public static void main(String[] args) {
        // 一边吃饭一边喝酒
        new Thread00().start();
        new Thread01().start();
    }
}

class Thread00 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 31; i++) {
            System.out.println(i);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread01 extends Thread {
    @Override
    public void run() {
        char j;
        for(int i=97;i<123;i++){
            j =(char) i;
            System.out.println(j);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
