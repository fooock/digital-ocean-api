package com.fooock.digital.ocean;

/**
 * This object contains information about the response itself.
 * <p>
 * The meta object contains a total key that is set to the total number of objects returned by the request.
 */
public class Metadata {

    private final int total;

    /**
     * Create this object
     *
     * @param total total number of objects returned by request
     */
    public Metadata(int total) {
        this.total = total;
    }

    public int total() {
        return total;
    }
}
