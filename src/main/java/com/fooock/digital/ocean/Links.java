package com.fooock.digital.ocean;

/**
 * This object is returned as part of the response body when pagination is enabled.
 * By default, 25 objects are returned per page. If the response contains 25 objects or fewer, no
 * links object will be returned. If the response contains more than 25 objects, the first 25 will
 * be returned along with the links object.
 * <p>
 * The links object contains a pages object. The pages object, in turn, contains keys indicating
 * the relationship of additional pages.
 */
public class Links {

    private final Page pages;

    public Links(Page pages) {
        this.pages = pages;
    }

    /**
     * @return Additional pages
     */
    public Page pages() {
        return pages;
    }

    /**
     * Check if this response has link pages available
     *
     * @return True if the link have pages, false if not
     */
    public boolean hasPages() {
        return pages != null;
    }
}
