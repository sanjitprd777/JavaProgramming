package MultiThreading.SynchronizedBlocks.StaticBlock;


public class Main {
    public static void main(String[] args) {

        Thread th = new Thread(() -> {
            for (int i=0;i<1000;++i)
                StaticSync.setObject(String.valueOf(i));
        });

        Thread th2 = new Thread(() -> {
            for (int i=0;i<1000;++i)
                System.out.println(StaticSync.getObj());
        });

        th2.start();
        th.start();

        /*
        Caution: Do not use Integer, String, Double, object as monitor object for synchronizaiton.
        Because Java compiler might use optimisation and replace diff string obj with same object.
        Same is true for object such as Integer, Double, etc.
        Only use Object class is better.

         */
    }

}
