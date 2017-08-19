package com.fooock.digital.ocean.region;

import com.fooock.digital.ocean.ApiException;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Digital Ocean regions
 */
public interface RegionService {

    /**
     * Get all {@link Region}s
     *
     * @return List of regions
     * @throws ApiException If an error occurs
     */
    @GET("regions")
    Call<RegionsResponse> all() throws ApiException;
}
