package com.fooock.digital.ocean.actions;

/**
 * Response object for the {@link ActionService#get(long)}
 */
public class ActionResponse {

    private final Action action;

    /**
     * Create this object
     *
     * @param action Action object
     */
    public ActionResponse(Action action) {
        this.action = action;
    }

    public Action action() {
        return action;
    }
}
