package de.lasagevo.badalgs.algorithms;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing selection sort.
 */
public class SortingTest {

    private int[] toSort1;
    private int[] toSort2;
    private int[] toSort3;
    private int[] toSort4;

    private SortingTest() {
    }

    @BeforeEach
    void initArrays() {
        toSort1 = arrayOf(5, 4, 3, 2, 1);
        toSort2 = arrayOf(1, 2, 3, 4, 5, 6);
        toSort3 = arrayOf(-65, 46, 101, 20, 300);
        toSort4 = arrayOf(0, -345, 43, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int[] arrayOf(int... arr) {
        return arr;
    }

    @Test
    void selectionSortTest() {
        final SortingAlgorithm sorting = new SelectionSort();

        sorting.sort(toSort1);
        sorting.sort(toSort2);
        sorting.sort(toSort3);
        sorting.sort(toSort4);

        Assertions.assertThat(toSort1).isSorted();
        Assertions.assertThat(toSort2).isSorted();
        Assertions.assertThat(toSort3).isSorted();
        Assertions.assertThat(toSort4).isSorted();
    }

    @Test
    void insertionSortTest() {
        final SortingAlgorithm sorting = new InsertionSort();

        sorting.sort(toSort1);
        sorting.sort(toSort2);
        sorting.sort(toSort3);
        sorting.sort(toSort4);

        Assertions.assertThat(toSort1).isSorted();
        Assertions.assertThat(toSort2).isSorted();
        Assertions.assertThat(toSort3).isSorted();
        Assertions.assertThat(toSort4).isSorted();
    }

    @Test
    void bubbleSortTest() {
        final SortingAlgorithm sorting = new BubbleSort();

        sorting.sort(toSort1);
        sorting.sort(toSort2);
        sorting.sort(toSort3);
        sorting.sort(toSort4);

        Assertions.assertThat(toSort1).isSorted();
        Assertions.assertThat(toSort2).isSorted();
        Assertions.assertThat(toSort3).isSorted();
        Assertions.assertThat(toSort4).isSorted();
    }

}
