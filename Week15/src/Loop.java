public class Loop {
    public static void main(String[] args) {
        new Thread02().start();
        new Thread03().start();
        try {
            Thread.sleep(10000);
            Thread02.interrupt();
            Thread03.interrupt();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread02 extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i < 31; i++) {
                System.out.println(i);
            }
        }
    }
}

class Thread03 extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            char j;
            for (int i = 97; i < 123; i++) {
                j=(char)i;
                System.out.println(j);
            }
        }
    }
}
