package com.fooock.digital.ocean.image;

import com.fooock.digital.ocean.ApiException;
import com.fooock.digital.ocean.ReadResources;
import com.fooock.digital.ocean.action.ActionsResponse;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.Calls;

/**
 *
 */
public class EmptyImageService implements ImageService {

    private final BehaviorDelegate<ImageService> behaviorDelegate;
    private final ReadResources readResources = new ReadResources();

    EmptyImageService(BehaviorDelegate<ImageService> behaviorDelegate) {
        this.behaviorDelegate = behaviorDelegate;
    }

    @Override
    public Call<ImagesResponse> all() throws ApiException {
        return getImageResponseCall();
    }

    @Override
    public Call<ImagesResponse> allForType(String type) throws ApiException {
        return getImageResponseCall();
    }

    @Override
    public Call<ImagesResponse> allUserPrivate() throws ApiException {
        return getImageResponseCall();
    }

    @Override
    public Call<ActionsResponse> getActions(long id) throws ApiException {
        return null;
    }

    @Override
    public Call<ImageResponse> get(long id) throws ApiException {
        return null;
    }

    @Override
    public Call<ImageResponse> get(String slug) throws ApiException {
        return null;
    }

    private Call<ImagesResponse> getImageResponseCall() throws ApiException {
        final String content = readResources.loadJson("src/test/resources/images/empty_images.json");
        final ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), content);
        final ImagesResponse imagesResponse = new Gson().fromJson(responseBody.charStream(), ImagesResponse.class);
        final Response<ImagesResponse> response = Response.success(imagesResponse);
        return behaviorDelegate.returning(Calls.response(response)).all();
    }
}
