package EX3;

import java.util.*;

/**
 * FUI FAZER O EXERCICIO 4 E ACABEI QUEBRANDO O PROJETO, MAS ESTAVA TUDO FUNCIONANDO DO EXERCICIO 1, 2,3 E 5
 */

public class MultiArrayList<T> extends ArrayList<T>
{
	private static final long serialVersionUID = -6453640737001548111L;

	private List<T> list1;

	private List<Integer> frequency;

	private final String ERROR_MSG = "Count cannot be negative: ";

	public MultiArrayList()
	{
		this.list1 = new ArrayList<>();
		this.frequency = new ArrayList<>();
	}

	public T getElement(int index)
	{
		return (list1.get(index));
	}

	public Integer getFrequency(int index)
	{
		return (frequency.get(index));
	}

	/**
	 * Adds and element to this multiset specified number of times
	 * 
	 * @param 'element' The element to be added
	 * @param 'count'   The number of times
	 * @return The previous count of the element
	 */
	public int add(T element, int count)
	{
		if (count < 0)
		{
			throw new IllegalArgumentException(ERROR_MSG + count);
		}
		int index = list1.indexOf(element);
		int prevCount = 0;

		if (index != -1)
		{
			prevCount = frequency.get(index);
			frequency.set(index, prevCount + count);
		} else if (count != 0)
		{
			list1.add(element);
			frequency.add(count);
		}
		return (prevCount);
	}

	/**
	 * @param 'element' The element to be added
	 * @return true always
	 */
	// @Override
	public boolean add(T element)
	{
		return (add(element, 1) >= 0);
	}

	/**
	 * Adds all elements in the specified collection to this multiset
	 * 
	 * @param 'c' Collection containing elements to be added
	 * @return true if all elements are added to this multiset
	 */
	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		for (T element : c)
		{
			add(element, 1);
		}
		return (true);
	}

	/**
	 * Adds all elements in the specified multiset to this multiset
	 * 
	 * @param 'm' A multiset containing elements to be added
	 */
	public void addAll(MultiArrayList<T> m)
	{
		for (int i = 0; i < m.size(); i++)
		{
			add(m.getElement(i), m.getFrequency(i));
		}
	}

	public boolean equals(MultiArrayList<T> m)
	{
		for (int i = 0; (i < m.size()) && (i < this.size()); i++)
		{
			if (this.getElement(i) != m.getElement(i))
			{
				return (false);
			}
		}
		return (true);
	}

	@Override
	public int size()
	{
		int size = 0;
		for (Integer i : frequency)
		{
			size += i;
		}
		return (size);
	}

	@Override
	public String toString()
	{
		StringBuilder sB = new StringBuilder("[");
		for (int i = 0; i < list1.size(); i++)
		{
			sB.append(list1.get(i));

			if (frequency.get(i) > 1)
			{
				sB.append(" x ").append(frequency.get(i));
			}

			if (i != list1.size() - 1)
			{
				sB.append(", ");
			}
		}

		return (sB.append("]").toString());
	}
}