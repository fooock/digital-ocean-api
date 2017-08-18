package com.fooock.digital.ocean.region;

import com.fooock.digital.ocean.ApiException;
import retrofit2.Call;

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
    Call<RegionsResponse> all() throws ApiException;
}
