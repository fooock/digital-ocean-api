package com.fooock.digital.ocean;

/**
 * Object that contains keys indicating the relationship of additional pages.
 * <p>
 * The values of these are the URLs of the associated pages. The keys will be one of the following:
 * <ul>
 * <li><strong>first</strong>: The URI of the first page of results.</li>
 * <li><strong>prev</strong>: The URI of the previous sequential page of results.</li>
 * <li><strong>next</strong>: The URI of the next sequential page of results.</li>
 * <li><strong>last</strong>: The URI of the last page of results.</li>
 * </ul>
 * <p>
 * The pages object will only include the links that make sense. So for the first page of results,
 * no first or prev links will ever be set. This convention holds true in other situations where a
 * link would not make sense.
 */
public class Page {

    private final String first;
    private final String prev;
    private final String next;
    private final String last;

    /**
     * Create this object
     *
     * @param first The URI of the first page of results. Can be null
     * @param prev  The URI of the previous sequential page of results. Can be null
     * @param next  The URI of the next sequential page of results. Can be null
     * @param last  The URI of the last page of results. Can be null
     */
    public Page(String first, String prev, String next, String last) {
        this.first = first;
        this.prev = prev;
        this.next = next;
        this.last = last;
    }

    /**
     * @return The URI of the first page of results
     */
    public String first() {
        return first;
    }

    /**
     * @return The URI of the previous sequential page of results
     */
    public String previous() {
        return prev;
    }

    /**
     * @return The URI of the next sequential page of results
     */
    public String next() {
        return next;
    }

    /**
     * @return The URI of the last page of results
     */
    public String last() {
        return last;
    }

    /**
     * Check if first page element exist
     *
     * @return True if exists, false if not
     */
    public boolean hasFirst() {
        return first != null && !first.isEmpty();
    }

    /**
     * Check if previous page element exist
     *
     * @return True if exists, false if not
     */
    public boolean hasPrevious() {
        return prev != null && !prev.isEmpty();
    }

    /**
     * Check if next page element exist
     *
     * @return True if exists, false if not
     */
    public boolean hasNext() {
        return next != null && !next.isEmpty();
    }

    /**
     * Check if last page element exist
     *
     * @return True if exists, false if not
     */
    public boolean hasLast() {
        return last != null && !last.isEmpty();
    }
}
