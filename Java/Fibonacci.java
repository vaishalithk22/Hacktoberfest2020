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



Class Fibonacci {
    public static long fib(int x) {
        if(x<2)
        return x;
        int a=0,b=1,c=0;
        for(int i=2;i<=x;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

    public static void main(String args[]) {
        Reader.init(System.in);
        int n = Reader.nextInt();
        System.out.println("The "+n+"th Fibonacci number is: "+fib(n));
        
    }
}
