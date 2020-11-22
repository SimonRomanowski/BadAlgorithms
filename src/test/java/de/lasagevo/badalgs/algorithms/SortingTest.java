package de.lasagevo.badalgs.algorithms;


import de.lasagevo.badalgs.UiPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;

/**
 * Testing selection sort.
 */
public class SortingTest {

    private final int[][] toSort = new int[5][];

    private SortingTest() {
    }

    @BeforeEach
    void initArrays() {
        toSort[0] = arrayOf(5, 4, 3, 2, 1);
        toSort[1] = arrayOf(1, 2, 3, 4, 5, 6);
        toSort[2] = arrayOf(-65, 46, 101, -20, 300);
        toSort[3] = arrayOf(0, -345, 43, Integer.MIN_VALUE, Integer.MAX_VALUE);
        toSort[4] = arrayOf(6, 7, 1, 9, 5, 0, 4, 6, 1, 5, 10, -4, 0, 3);
    }

    private int[] arrayOf(int... arr) {
        return arr;
    }

    @Test
    void selectionSortTest() {
        final SortingAlgorithm sorting = new SelectionSort();

        assertSortingWorks(sorting);
    }

    @Test
    void selectionSortVerboseTest() {
        final SortingAlgorithm sorting = new SelectionSort();

        assertVerboseSortingWorks(sorting);
    }

    @Test
    void insertionSortTest() {
        final SortingAlgorithm sorting = new InsertionSort();

        assertSortingWorks(sorting);
    }

    @Test
    void insertionSortVerboseTest() {
        final SortingAlgorithm sorting = new InsertionSort();

        assertVerboseSortingWorks(sorting);
    }

    @Test
    void bubbleSortTest() {
        final SortingAlgorithm sorting = new BubbleSort();

        assertSortingWorks(sorting);
    }

    @Test
    void bubbleSortVerboseTest() {
        final SortingAlgorithm sorting = new BubbleSort();

        assertVerboseSortingWorks(sorting);
    }

    @Test
    void quickSortTest() {
        final SortingAlgorithm sorting = new QuickSort();

        assertSortingWorks(sorting);
    }

    @Test
    void quickSortVerboseTest() {
        final SortingAlgorithm sorting = new QuickSort();

        assertVerboseSortingWorks(sorting);
    }

    @Test
    void heapSortTest() {
        final SortingAlgorithm sorting = new HeapSort();

        assertSortingWorks(sorting);
    }

    @Test
    void heapSortVerboseTest() {
        final SortingAlgorithm sorting = new HeapSort();

        assertVerboseSortingWorks(sorting);
    }

    private void assertSortingWorks(final SortingAlgorithm sorting) {
        for (int[] ints : toSort) {
            sorting.sort(ints);
            assertThat(ints).isSorted();
        }
    }

    private void assertVerboseSortingWorks(final SortingAlgorithm sorting) {
        UiPrinter printer = mock(UiPrinter.class);
        for (int[] ints : toSort) {
            sorting.sortVerbose(printer, ints);
            assertThat(ints).isSorted();
        }
    }



}
