/**
 * Created by IntelliJ IDEA.
 * User: rsv
 * Date: 03.10.2020
 * Time: 19:18
 */
public class ReverseString {

    public static void main(final String[] args) {
        String string = System.console().readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = string.length() - 1; i > -1; i--) {
            sb.append(string.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
