package com.fooock.digital.ocean.action;

import com.fooock.digital.ocean.ApiException;
import com.fooock.digital.ocean.ReadResources;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.Calls;

public class SingleActionService implements ActionService {

    private final BehaviorDelegate<ActionService> behaviorDelegate;
    private final ReadResources readResources = new ReadResources();

    SingleActionService(BehaviorDelegate<ActionService> behaviorDelegate) {
        this.behaviorDelegate = behaviorDelegate;
    }

    @Override
    public Call<ActionsResponse> all() throws ApiException {
        final String content = readResources.loadJson("src/test/resources/actions/one_action.json");
        final ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), content);
        final ActionsResponse actionsResponse = new Gson().fromJson(responseBody.charStream(), ActionsResponse.class);
        final Response<ActionsResponse> response = Response.success(actionsResponse);
        return behaviorDelegate.returning(Calls.response(response)).all();
    }

    @Override
    public Call<ActionResponse> get(long id) throws ApiException {
        final String content = readResources.loadJson("src/test/resources/actions/get_one_action.json");
        final ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), content);
        final ActionResponse actionsResponse = new Gson().fromJson(responseBody.charStream(), ActionResponse.class);
        final Response<ActionResponse> response = Response.success(actionsResponse);
        return behaviorDelegate.returning(Calls.response(response)).get(id);
    }
}
