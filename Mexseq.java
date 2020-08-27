/**
 * Name         : Yap Kai Herng
 * Matric. No   : A199729A
 */

import java.util.*;

public class Mexseq {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int targetMex = sc.nextInt();
        int counter = 0;
        List<Integer> unique = new ArrayList<>(length);
        while (sc.hasNextInt()) {
            int curr = sc.nextInt();
            if (!unique.contains(curr) && curr < targetMex ) {
                unique.add(curr);
            }
            //need to remove the number if the number == targetMex
            if (curr == targetMex) {
                counter++;
            }
        }
        /* the size() of unique is the number of ints lower than the
         targetMex i.e. the ones that don't need to be added. 
         targetMex - unique.size() gives the number of nonzero ints
         that need to be added to make sure targetMex is the Mex. 
        */
        int toAdd = targetMex - unique.size();
        counter += toAdd;
        System.out.println(counter);
    }

    public static void main(String[] args) {
        Mexseq newMexseq = new Mexseq();
        newMexseq.run();
    }
}
