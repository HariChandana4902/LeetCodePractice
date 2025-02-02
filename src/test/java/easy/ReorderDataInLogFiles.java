package easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>Leetcode question: 937</p>
 * <p>Link to question: https://leetcode.com/problems/reorder-data-in-log-files/</p>
 * <p>Link to solution: My solution</p>
 * <p>Link to preferred solution: </p>
 */
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            // split each log into two parts: <identifier, content>
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // case 1. both logs are letter-logs
            if (!isDigit1 && !isDigit2) {
                // first compare the content
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                    return cmp;
                // logs of same content, compare the identifiers
                return split1[0].compareTo(split2[0]);
            }

            // case 2. one of logs is digit-log
            if (!isDigit1)
                // the letter-log comes before digit-logs
                return -1;
            else if (!isDigit2)
                return 1;
            else
                // case 3). both logs are digit-log
                return 0;
        });
        return logs;
    }

    @Test
    public void test1() {

    }

    @Test
    public void test2() {

    }
}