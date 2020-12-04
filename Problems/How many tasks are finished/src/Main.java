import java.util.*;
import java.util.concurrent.*;


class FutureUtils {

    public static int howManyIsDone(List<Future> items) {
        int answer = 0;
        for (Future f : items) {
            if (f.isDone()) {
                answer++;
            }
        }
        return answer;
    }

}