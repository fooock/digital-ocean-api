package com.fooock.digital.ocean.size;

import com.fooock.digital.ocean.ApiException;
import com.fooock.digital.ocean.ReadResources;
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
public class SuccessSizeService implements SizeService {

    private final BehaviorDelegate<SizeService> behaviorDelegate;
    private final ReadResources readResources = new ReadResources();

    SuccessSizeService(BehaviorDelegate<SizeService> behaviorDelegate) {
        this.behaviorDelegate = behaviorDelegate;
    }

    @Override
    public Call<SizeResponse> all() throws ApiException {
        final String content = readResources.loadJson("src/test/resources/sizes/sizes.json");
        final ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), content);
        final SizeResponse regionService = new Gson().fromJson(responseBody.charStream(), SizeResponse.class);
        final Response<SizeResponse> response = Response.success(regionService);
        return behaviorDelegate.returning(Calls.response(response)).all();
    }
}
