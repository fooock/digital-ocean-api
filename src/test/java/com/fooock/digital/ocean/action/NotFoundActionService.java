package com.fooock.digital.ocean.action;

import com.fooock.digital.ocean.ApiException;
import com.fooock.digital.ocean.ReadResources;
import com.fooock.digital.ocean.ResponseError;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.Calls;

/**
 *
 */
public class NotFoundActionService implements ActionService {

    private final BehaviorDelegate<ActionService> behaviorDelegate;
    private final ReadResources readResources = new ReadResources();

    NotFoundActionService(BehaviorDelegate<ActionService> behaviorDelegate) {
        this.behaviorDelegate = behaviorDelegate;
    }

    @Override
    public Call<ActionsResponse> all() throws ApiException {
        return null;
    }

    @Override
    public Call<ActionResponse> get(long id) throws ApiException {
        final String content = readResources.loadJson("src/test/resources/not_found.json");
        final ResponseBody body = ResponseBody.create(MediaType.parse("application/json"), content);
        final Response<ResponseError> response = Response.error(404, body);
        return behaviorDelegate.returning(Calls.response(response)).get(id);
    }
}
