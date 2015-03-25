
public class Logic {

	private byte[] S=new byte[256];
    private byte[] T=new byte[256];

    
    //step1: initialize the byte array
    public void initialize(byte[] key){
        for (int i = 0; i < 256; i++) {
                S[i] = (byte)i;
                T[i] = key[i % 256];
        }        
    }
    
    
    //step2:perform permutation on the byte array
    public void permutation(){
    	   int j = 0;
    	   byte temp;
    	   for (int i = 0; i < 256; i++) {
        	       j = (j + S[i] + T[i]) % 256;
                   temp = S[i];
                   S[i] = S[j];
                   S[j] = temp;
           }
    }
    
    //step3:encrypt or decrypt the file
    public byte[] encrypt(byte[] plainText) {
        byte[] cipherText = new byte[plainText.length];
        int i = 0, j = 0;
        int k;
        byte temp; int key;
        for (int counter = 0; counter < plainText.length; counter++) {
                i = (i + 1) % 256;
                j = (j + S[i]) % 256;
                temp = S[i];
                S[i] = S[j];
                S[j] = temp;
                k = (S[i] + S[j]) % 256;
                key = S[k];
                cipherText[counter] = (byte) (plainText[counter] ^ key);
        }
        return cipherText;
    }
    
    public byte[] decrypt(byte[] cipherText) {
        return encrypt(cipherText);
    }

	
}
