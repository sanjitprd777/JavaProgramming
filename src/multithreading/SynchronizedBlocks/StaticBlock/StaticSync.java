package multithreading.SynchronizedBlocks.StaticBlock;

public class StaticSync {

    public static Object obj = null;

    public static synchronized void setObject(Object o) {
        obj = o;
    }

    public static synchronized Object getObject() {
        return obj;
    }

    public static void setObj(Object o) {
        synchronized (StaticSync.class) {
            obj = o;
        }
    }

    public static Object getObj() {
        synchronized (StaticSync.class) {
            return obj;
        }
    }
}
