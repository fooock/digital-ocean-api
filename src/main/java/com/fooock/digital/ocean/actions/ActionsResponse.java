package com.fooock.digital.ocean.actions;

import com.fooock.digital.ocean.Links;
import com.fooock.digital.ocean.Metadata;

import java.util.List;

/**
 * Response object for the {@link ActionService#all()}
 */
public class ActionsResponse {

    private final Metadata meta;
    private final Links links;

    private final List<Action> actions;

    /**
     * Create this object
     *
     * @param meta    {@link Metadata} for this response
     * @param links   {@link Links} for this response
     * @param actions List of {@link Action}s
     */
    public ActionsResponse(Metadata meta, Links links, List<Action> actions) {
        this.meta = meta;
        this.links = links;
        this.actions = actions;
    }

    /**
     * @return {@code Metadata} for this response
     */
    public Metadata metadata() {
        return meta;
    }

    /**
     * @return {@code Links} for this response
     */
    public Links links() {
        return links;
    }

    /**
     * @return List of {@code Action}s
     */
    public List<Action> actions() {
        return actions;
    }
}
