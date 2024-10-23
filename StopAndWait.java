import java.util.Random;

public class StopAndWait {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void stopAndWait(int[] frames) {
        for (int frame : frames) {
            while (true) {
                System.out.println("Sending:" + frame);
                boolean ack = getAck(frame);
                if (ack) {
                    System.out.println("Acknowledgement recieved...");
                    break;
                } else {
                    System.out.println("Sender: No acknowledgment, resending frame " + frame);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean getAck(int frame){
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public static void main(String[] args) {
        int[] frames = {1,2,3,4,5};
        stopAndWait(frames);
    }
}