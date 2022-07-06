package Problems.OnlineBinPacking;

import java.io.IOException;
import java.util.*;

public class UserFile {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();
        int n = 0; // The number of item.
        int c = 0; // Capacity of each bin.
        while (scanner.hasNextLine()) {
            int p = scanner.nextInt();
            if (p < 1000 && p >= 0) {
                input.add(p);
                n += 1;
            } else if (p >= 1000) {
                c = p;
            } else {
                throw new IOException("Wrong problem!");

            }
        }
        scanner.close();

        // Initialize result (Count of bins) and remaining
        // capacity in current bin.
        int res = 0, bin_rem = c;

        for (int i = 0; i < n; i++) {
            // If this item can't fit in current bin
            if (input.get(i) > bin_rem) {
                res++; // new bin
                bin_rem = c - input.get(i);
            }
            bin_rem -= input.get(i);
        }


        System.out.println(res);

    }
}
