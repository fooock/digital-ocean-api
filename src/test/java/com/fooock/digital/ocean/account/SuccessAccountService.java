package com.fooock.digital.ocean.account;

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
public class SuccessAccountService implements AccountService {

    private final BehaviorDelegate<AccountService> behaviorDelegate;
    private final ReadResources readResources = new ReadResources();

    SuccessAccountService(BehaviorDelegate<AccountService> behaviorDelegate) {
        this.behaviorDelegate = behaviorDelegate;
    }

    @Override
    public Call<AccountResponse> account() throws ApiException {
        final String content = readResources.loadJson("src/test/resources/account/account.json");
        final ResponseBody body = ResponseBody.create(MediaType.parse("application/json"), content);
        final AccountResponse account = new Gson().fromJson(body.charStream(), AccountResponse.class);
        final Response<AccountResponse> response = Response.success(account);
        return behaviorDelegate.returning(Calls.response(response)).account();
    }
}
