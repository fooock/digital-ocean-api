package com.fooock.digital.ocean;

/**
 * Contains info when the provided token is not valid, or the user is not authorized
 */
public class AuthFail {

    private final String id;
    private final String message;

    /**
     * Create this object
     *
     * @param id      Message id
     * @param message Message content
     */
    public AuthFail(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
