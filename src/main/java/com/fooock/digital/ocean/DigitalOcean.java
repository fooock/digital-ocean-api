package com.fooock.digital.ocean;

import com.fooock.digital.ocean.account.AccountService;

/**
 * Digital Ocean entry point
 */
public interface DigitalOcean {

    String ENDPOINT_V2 = "https://api.digitalocean.com/v2/";

    /**
     * Get the account service to get user information
     *
     * @return {@code AccountService}
     */
    AccountService accountService();
}
