import com.zzz.tutorial.sorting.MergeSort;
import org.junit.Assert;
import org.junit.Test;


public class MergeSortTest {

    @Test
    public void test_MergeSort() {
        Integer[] input = new Integer[]{29, 85, 67, 23, 7};
        Integer[] output = new Integer[]{7, 23, 29, 67, 85};
        MergeSort<Integer> merge = new MergeSort<>(input);
        merge.sort();
        Assert.assertArrayEquals(input, output);
    }

    @Test
    public void test_mergesort_null(){
        MergeSort<Integer> merge = new MergeSort<>(null);
        merge.sort();
    }
}
