import java.util.Comparator;
// A comparator that implements the natural ordering.
// (c) 2001 duane a. bailey

/**
 * Implementation of the {@link java.util.Comparator} interface that
 * provides a {@link #compare} method that compares two objects using those
 * objects default compareTo methods.
 * </pre>
 * @author, 2001 duane a. bailey
 */
public class NaturalComparator<E extends Comparable<E>>
                 implements Comparator<E>
{
    public int compare(E a, E b)
    {
        return a.compareTo(b);
    }

    public boolean equals(Object b)
    {
        return (b != null) && (b instanceof NaturalComparator);
    }
}
