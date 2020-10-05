class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;



    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }


    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {


            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {

    	return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

public class Ceasercipher {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Encryption using plaintext and shiftkey
     * 
     * @param plainText
     * @param shiftKey
     * @return
     */
    public static String encrypt(String plainText, int shiftKey) {
        plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }

    /**
     * Decryption using encrypted value and shift key which used in encryption.
     * 
     * @param cipherText
     * @param shiftKey
     * @return
     */
    public static String decrypt(String cipherText, int shiftKey) {
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }

    public static void main(String[] args) {
        Reader.init(System.in);
        System.out.println("Enter the String for Encryption: ");
        String message = new String();
        message = Reader.next();
        System.out.println(encrypt(message, 3));
        System.out.println(decrypt(encrypt(message, 3), 3));
        sc.close();
    }

}
