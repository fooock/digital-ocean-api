package com.fooock.digital.ocean.size;

import com.fooock.digital.ocean.ApiException;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Digital Ocean hardware {@link Size}s
 */
public interface SizeService {

    /**
     * Get all {@link Size}s
     *
     * @return List of supported {@link Size}s
     * @throws ApiException If an unexpected error occurs
     */
    @GET("sizes")
    Call<SizeResponse> all() throws ApiException;
}
