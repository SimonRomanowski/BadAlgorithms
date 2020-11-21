package de.lasagevo.badalgs.algorithms;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing selection sort.
 */
public class SortingTest {

    private int[][] toSort = new int[4][];

    private SortingTest() {
    }

    @BeforeEach
    void initArrays() {
        toSort[0] = arrayOf(5, 4, 3, 2, 1);
        toSort[1] = arrayOf(1, 2, 3, 4, 5, 6);
        toSort[2] = arrayOf(-65, 46, 101, -20, 300);
        toSort[3] = arrayOf(0, -345, 43, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int[] arrayOf(int... arr) {
        return arr;
    }

    @Test
    void selectionSortTest() {
        final SortingAlgorithm sorting = new SelectionSort();

        for (int[] ints : toSort) {
            sorting.sort(ints);
            assertThat(ints).isSorted();
        }
    }

    @Test
    void insertionSortTest() {
        final SortingAlgorithm sorting = new InsertionSort();

        for (int[] ints : toSort) {
            sorting.sort(ints);
            assertThat(ints).isSorted();
        }
    }

    @Test
    void bubbleSortTest() {
        final SortingAlgorithm sorting = new BubbleSort();

        for (int[] ints : toSort) {
            sorting.sort(ints);
            assertThat(ints).isSorted();
        }
    }

    @Test
    void quickSortTest() {
        final SortingAlgorithm sorting = new QuickSort();

        for (int[] ints : toSort) {
            sorting.sort(ints);
            assertThat(ints).isSorted();
        }
    }

}
