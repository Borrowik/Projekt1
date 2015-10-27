package pl.sortAlgorithmsTests;

import org.junit.Assert;
import org.junit.Test;

import pl.sortAlgorithms.StopWatch;

public class TestStopWatch {

	// stop watch innitialization
	@Test
	public final void StopWatchTest() {

		// given
		StopWatch timer;

		// when
		timer = new StopWatch();

		// then
		Assert.assertEquals(timer.isRunning(), false);
	}

	// stop watch start
	@Test
	public final void StopWatchTest1() {

		// given
		StopWatch timer1 = new StopWatch();

		// when
		timer1.start();
		// then
		Assert.assertEquals(timer1.isRunning(), true);
		timer1.stop();
	}

	// stop watch stop
	@Test
	public final void StopWatchTest2() {

		// given
		StopWatch timer2 = new StopWatch();

		// when
		timer2.start();
		// then
		timer2.stop();
		Assert.assertEquals(timer2.isRunning(), false);

	}

	// stop watch time
	@Test
	public final void StopWatchTest3() {

		// given
		StopWatch timer3 = new StopWatch();

		// when
		timer3.start();

		try {
			Thread.sleep(1000);
			timer3.stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 1000 milliseconds is one second.

		// then

		Assert.assertEquals(1000, timer3.getElapsedTime());

	}

	// stop watch time
	@Test
	public final void StopWatchTest4() {

		// given
		StopWatch timer4 = new StopWatch();
		long tempTime;

		// when
		timer4.start();
		try {
			Thread.sleep(1000); // 1000 milliseconds is one second.
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		tempTime = timer4.getElapsedTime();

		try {
			Thread.sleep(500); // 1000 milliseconds is one second.
			timer4.stop();
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		// then
		Assert.assertEquals(1500, timer4.getElapsedTime());
		Assert.assertEquals(1000, tempTime);

	}

	// stop watch timeSec
	@Test
	public final void StopWatchTest5() {

		// given
		StopWatch timer5 = new StopWatch();
		long tempTime;

		// when
		timer5.start();
		try {
			Thread.sleep(1000); // 1000 milliseconds is one second.
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		tempTime = timer5.getElapsedTimeSecs();

		try {
			Thread.sleep(1000); // 1000 milliseconds is one second.
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		// then
		Assert.assertEquals(2, timer5.getElapsedTimeSecs());
		Assert.assertEquals(1, tempTime);
		timer5.stop();

	}
}
