package com.fooock.digital.ocean.actions;

import com.fooock.digital.ocean.ApiException;
import retrofit2.Call;

/**
 * Service to retrieve actions
 */
public interface ActionService {

    /**
     * List all actions
     *
     * @return All actions
     * @throws ApiException If an unexpected error occurs
     */
    Call<ActionsResponse> all() throws ApiException;

    /**
     * Retrieve an existing {@link Action}
     *
     * @param id Action id
     * @return Action associated with the given {@code id}
     * @throws ApiException If an unexpected error occurs
     */
    Call<ActionResponse> get(long id) throws ApiException;
}
