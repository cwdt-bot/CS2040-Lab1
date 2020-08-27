/**
 * Name         : Yap Kai Herng
 * Matric. No   : A199729A
*/

import java.util.*;

public class Bigcal {
    private void run() {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        String longer = first.length() >= second.length() ? first :
        second;
        String shorter = first.length() >= second.length() ? second :
        first;
        //add zeroes to the shorter string to make then same length
        while (shorter.length() < longer.length()) {
            shorter = "0" + shorter;
        }
        int carry = 0;
        String result = "";
        for (int x = longer.length()-1; x >= 0; x--) {
            int f = Integer.parseInt(String.valueOf(longer.charAt(x)));
            int s = Integer.parseInt(String.valueOf(shorter.charAt(x)));
            int curr = f + s + carry;
            result =Integer.toString(curr%10) + result;
            carry = curr/10;
        }
        if (carry != 0) result = "1" + result;
        System.out.println(result);
    }

    public static void main(String[] args) {
        Bigcal newBigcal = new Bigcal();
        newBigcal.run();
    }
}
