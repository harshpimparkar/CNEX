import java.util.Random;

public class GoBackN {

    public static void goBackN(int[] frames, int windowSize) {
        int n = frames.length;
        int windowStart = 0;
        int next = 0;

        while (windowStart < n) {
            while (next < windowStart + windowSize && next < n) {
                System.out.println("Sender:sending " + frames[next]);
                next++;
            }
            boolean ack = getAck(frames[windowStart]);

            if (ack) {
                System.out.println("Sender: Acknowledgment received for frame " + frames[windowStart]);
                windowStart++;
            } else {
                System.out.println("Sender: Timeout, resending from frame " + frames[windowStart]);
                next = windowStart;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean getAck(int frame) {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public static void main(String[] args) {
        // Sample frames
        int[] frames = {1, 2, 3, 4, 5};
        int windowSize = 3;  // Sliding window size

        goBackN(frames, windowSize);
    }
}
