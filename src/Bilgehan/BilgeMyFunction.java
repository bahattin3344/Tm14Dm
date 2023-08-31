package Bilgehan;

public class BilgeMyFunction {
    public static void Bekle(int sn){

        try {
            Thread.sleep(sn*1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
