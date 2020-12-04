import java.util.concurrent.*;


class FutureUtils {

    public static int determineCallableDepth(Callable callable) throws Exception {
        // write your code here
        int count = 0;
        Object c = callable;
        while (c instanceof Callable) {
            count++;
            c = ((Callable<Object>) c).call();
        }

        return count;
    }


}