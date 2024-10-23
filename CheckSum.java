public class CheckSum {
    public static void main(String[] args) {
        int[] data = { 3, 5, 1, 7, 8 };
        System.out.println("data: ");
        for (int num : data) {
            System.out.println(num + " ");
        }

        int checksum = checkSum(data);
    }

    public static int checkSum(int[] data) {
        int sum = 0;

        for (int num : data) {
            sum += num;
        }
        String binSum = decToBin(sum, 8);
        System.out.println("Binary sum: " + binSum);

        int wrappedSum = wrapBits(sum);
        System.out.println("Wrapped Sum:" + wrappedSum);

        int checksum = (~wrappedSum) & 0xF;
        System.out.println("Complemented checksum (4 bits): " + decToBin(checksum, 4));
        return checksum;
    }

    public static int wrapBits(int value) {
        int wrappedVal = (value & 0xF) + (value >> 4);
        return wrappedVal;
    }

    public static String decToBin(int decimal, int bits) {
        return String.format("%" + bits + "s", Integer.toBinaryString(decimal)).replace(" ", "0");
    }

    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
