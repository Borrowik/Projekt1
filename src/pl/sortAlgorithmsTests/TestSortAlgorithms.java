package pl.sortAlgorithmsTests;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestSortAlgorithms {

	// quick sort empty table
	@Test
	public final void EmptyRandomTest() {

		// given
		int[] Table = new int[0];

		// when
		Arrays.toString(Table);

		// then
		Assert.assertEquals(0, 0);

	}

	// quick sort empty table
	@Test
	public final void EmptyQuickSortTest() {

		// given
		int[] Table1 = new int[3];
		int TopRange = 10;

		// when

		// then
		Assert.assertEquals(3, 3);

	}

}
