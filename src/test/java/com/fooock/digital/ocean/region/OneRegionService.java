package com.fooock.digital.ocean.region;

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
public class OneRegionService implements RegionService {

    private final BehaviorDelegate<RegionService> behaviorDelegate;
    private final ReadResources readResources = new ReadResources();

    OneRegionService(BehaviorDelegate<RegionService> behaviorDelegate) {
        this.behaviorDelegate = behaviorDelegate;
    }

    @Override
    public Call<RegionsResponse> all() throws ApiException {
        final String content = readResources.loadJson("src/test/resources/regions/one_region.json");
        final ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), content);
        final RegionsResponse regionService = new Gson().fromJson(responseBody.charStream(), RegionsResponse.class);
        final Response<RegionsResponse> response = Response.success(regionService);
        return behaviorDelegate.returning(Calls.response(response)).all();
    }
}
