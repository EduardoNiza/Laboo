package EX3;



/**
 * FUI FAZER O EXERCICIO 4 E ACABEI QUEBRANDO O PROJETO, MAS ESTAVA TUDO FUNCIONANDO DO EXERCICIO 1, 2,3 E 5
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class TestMultiset
{
	MultiArrayList<String> multiset;
	MultiArrayList<String> catMultiset;

	@BeforeEach
	public void setUp()
	{
		multiset = new MultiArrayList<String>();
		catMultiset = new MultiArrayList<String>();
		catMultiset.add("forTesting");
	}

	@Test
	public void testAdd1()
	{
		multiset.add("Eduardo");
		assertEquals("[Eduardo]", multiset.toString());
	}

	@Test
	public void testAdd2()
	{
		multiset.add("Eduardo", 1);
		assertEquals("[Eduardo]", multiset.toString());
	}

	@Test
	public void testAddAll1()
	{
		multiset.addAll(Arrays.asList("Eduardo", "Beatriz", "Niza"));
		assertEquals("[Eduardo, Beatriz, Niza]", multiset.toString());
	}

	@Test
	public void testAddAll2()
	{
		multiset.add("Edu");
		multiset.addAll(catMultiset);
		assertEquals("[Edu, forTesting]", multiset.toString());
	}

	@Test
	public void testEquals()
	{
		multiset.add("forTesting");
		assertTrue(multiset.equals(catMultiset));
	}
}