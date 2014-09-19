package collections;

import com.google.common.collect.ImmutableList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

@RunWith(JUnit4.class)
public class ListsTest {

	final private static Integer TWO = 2;

	final private static List<Integer> INTEGERS = new ImmutableList.Builder<Integer>().add(TWO, TWO, TWO, TWO, TWO).build();

	@Before
	public void before() { }

	@After
	public void after() { }

	@Test(expected = ConcurrentModificationException.class)
	public void testRemoveAllElementsFromListForEach() {
		final List<Integer> items = new ArrayList<>(INTEGERS);

		for (Integer item : items) {
			items.remove(item);
		}
	}

	@Test
	public void testRemoveAllByRemoveAll() {
		final List<Integer> items = new ArrayList<>(INTEGERS);

		items.removeAll(items);

		Assert.assertTrue(items.isEmpty());
	}

	@Test
	public void testRemoveAllElementsFromListWhile() {
		final List<Integer> items = new ArrayList<>(INTEGERS);

		while (!items.isEmpty()) {
			items.remove(0);
		}

		Assert.assertTrue(items.isEmpty());
	}

	@Test
	public void testRemoveAllElementsFromListIterator() {
		final List<Integer> items = new ArrayList<>(INTEGERS);

		final Iterator<Integer> iterator = items.iterator();
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}

		Assert.assertTrue(items.isEmpty());
	}

}
