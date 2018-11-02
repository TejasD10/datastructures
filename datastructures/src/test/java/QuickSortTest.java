import com.zzz.tutorial.sorting.QuickSort;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class QuickSortTest {


    @Test
    public void test_quicksort() {
        int[] input = {12, 11, 57, 32, 89};
        QuickSort.quickSort(input);
        int[] output = {11, 12, 32, 57, 89};
        Assert.assertArrayEquals(input, output);
    }

    @Test (expected = AssertionError.class)
    public void test_quicksort_sorted() {
        int[] input = {11, 12, 32, 57, 89};
        QuickSort.quickSort(input);
    }
}
