package com.fooock.digital.ocean.account;

import com.fooock.digital.ocean.ApiException;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Digital Ocean account service
 */
public interface AccountService {

    /**
     * Get user account information
     *
     * @return {@code AccountResponse}
     * @throws ApiException If an error occurs
     */
    @GET("account")
    Call<AccountResponse> account() throws ApiException;
}
