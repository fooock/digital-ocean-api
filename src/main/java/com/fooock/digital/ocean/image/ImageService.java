package com.fooock.digital.ocean.image;

import com.fooock.digital.ocean.ApiException;
import com.fooock.digital.ocean.action.ActionsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Service to retrieve {@link Image}s
 */
public interface ImageService {

    // TODO: Create update and delete methods for this service

    /**
     * Distribution images
     */
    String TYPE_DISTRIBUTION = "distribution";

    /**
     * Application images
     */
    String TYPE_APPLICATION = "application";

    /**
     * Get all images available on the current {@link com.fooock.digital.ocean.account.Account}
     *
     * @return List of all images
     * @throws ApiException If an unexpected error occurs
     */
    @GET("images")
    Call<ImagesResponse> all() throws ApiException;

    /**
     * Get all the images available for the given type. The types available
     * are {@link #TYPE_DISTRIBUTION} and {@link #TYPE_APPLICATION}
     *
     * @param type Type of the image
     * @return List of all images found for the given type
     * @throws ApiException If an unexpected error occurs
     */
    @GET("images")
    Call<ImagesResponse> allForType(@Query("type") String type) throws ApiException;

    /**
     * Retrieve only the private images for the current user
     *
     * @return List of all private images for the current user
     * @throws ApiException If an unexpected error occurs
     */
    @GET("images?private=true")
    Call<ImagesResponse> allUserPrivate() throws ApiException;

    /**
     * Retrieve all actions that have been executed on an image
     *
     * @param id Image id to retrieve all actions
     * @return List of {@link com.fooock.digital.ocean.action.Action}s for the given image
     * @throws ApiException If an unexpected error occurs
     */
    @GET("images/{id}/actions")
    Call<ActionsResponse> getActions(@Path("id") long id) throws ApiException;

    /**
     * Get information about one image (public or private) by id
     *
     * @param id Image id
     * @return Image
     * @throws ApiException If an unexpected error occurs
     */
    @GET("images/{id}")
    Call<ImageResponse> get(@Path("id") long id) throws ApiException;

    /**
     * Get information about one image (public or private) by slug
     *
     * @param slug Image slug
     * @return Image
     * @throws ApiException If an unexpected error occurs
     */
    @GET("images/{slug}")
    Call<ImageResponse> get(@Path("slug") String slug) throws ApiException;
}
