package com.fooock.digital.ocean.action;

import com.fooock.digital.ocean.ApiException;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

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
    @GET("actions")
    Call<ActionsResponse> all() throws ApiException;

    /**
     * Retrieve an existing {@link Action}
     *
     * @param id Action id
     * @return Action associated with the given {@code id}
     * @throws ApiException If an unexpected error occurs
     */
    @GET("actions/{id}")
    Call<ActionResponse> get(@Path("id") long id) throws ApiException;
}
