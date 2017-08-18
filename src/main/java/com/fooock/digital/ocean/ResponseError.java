package com.fooock.digital.ocean;

/**
 * Contains info when the provided token is not valid, the user is not authorized or the
 * resource is not found
 */
public class ResponseError {

    private final String id;
    private final String message;

    /**
     * Create this object
     *
     * @param id      Message id
     * @param message Message content
     */
    public ResponseError(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String id() {
        return id;
    }

    public String message() {
        return message;
    }
}
