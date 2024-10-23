public class CRC{
    public static void main(String[] args) {
        String dividend = "110101010";
        String divisor = "1011";
        String data = crc(dividend,divisor);
    }

    public static String crc(String dividend , String divisor){
        int len = divisor.length();
        String data = dividend + "0".repeat(len-1);
        char[] dend = data.toCharArray();
        char[] visor = divisor.toCharArray();

        for(int i=0;i<dend.length;i++){
            if(dend[i] == '1'){
                for(int j=0;j<len;j++){
                    dividend[i+j] = 
                }
            }
        }
        return rem;
    }
}