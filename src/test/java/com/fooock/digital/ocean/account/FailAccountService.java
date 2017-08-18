package com.fooock.digital.ocean.account;

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
public class FailAccountService implements AccountService {

    private final BehaviorDelegate<AccountService> behaviorDelegate;
    private final ReadResources readResources = new ReadResources();

    FailAccountService(BehaviorDelegate<AccountService> behaviorDelegate) {
        this.behaviorDelegate = behaviorDelegate;
    }

    @Override
    public Call<AccountResponse> account() throws ApiException {
        final String content = readResources.loadJson("src/test/resources/auth_fail.json");
        final ResponseBody body = ResponseBody.create(MediaType.parse("application/json"), content);
        final Response<ResponseError> response = Response.error(401, body);
        return behaviorDelegate.returning(Calls.response(response)).account();
    }
}
