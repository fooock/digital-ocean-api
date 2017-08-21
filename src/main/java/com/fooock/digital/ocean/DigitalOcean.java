package com.fooock.digital.ocean;

import com.fooock.digital.ocean.account.AccountService;
import com.fooock.digital.ocean.action.ActionService;
import com.fooock.digital.ocean.image.ImageService;
import com.fooock.digital.ocean.region.RegionService;
import com.fooock.digital.ocean.size.SizeService;

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

    /**
     * Get the action service to retrieve actions
     *
     * @return {@code ActionService}
     */
    ActionService actionService();

    /**
     * Get the region service
     *
     * @return {@code RegionService}
     */
    RegionService regionService();

    /**
     * Get the size service
     *
     * @return {@code SizeService}
     */
    SizeService sizeService();

    /**
     * Get the image service
     *
     * @return {@code ImageService}
     */
    ImageService imageService();
}
