package com.fooock.digital.ocean.account;

import com.fooock.digital.ocean.AuthFail;
import com.fooock.digital.ocean.DigitalOcean;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

import java.lang.annotation.Annotation;

import static org.junit.Assert.*;

/**
 *
 */
public class AccountServiceTest {

    private Retrofit retrofit;
    private MockRetrofit mockRetrofit;
    private BehaviorDelegate<AccountService> behaviorDelegate;

    @Before
    public void setUp() throws Exception {
        retrofit = new Retrofit.Builder()
                .baseUrl(DigitalOcean.ENDPOINT_V2)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final NetworkBehavior behavior = NetworkBehavior.create();
        mockRetrofit = new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior)
                .build();
        behaviorDelegate = mockRetrofit.create(AccountService.class);
    }

    @Test
    public void testUnauthorized() throws Exception {
        final FailAccountService failAccountService = new FailAccountService(behaviorDelegate);

        final Call<AccountResponse> account = failAccountService.account();
        final Response<AccountResponse> accountResponse = account.execute();
        assertFalse(accountResponse.isSuccessful());

        final Converter<ResponseBody, AuthFail> bodyConverter = retrofit.responseBodyConverter(
                AuthFail.class, new Annotation[0]);
        final AuthFail authFail = bodyConverter.convert(accountResponse.errorBody());

        assertEquals(401, accountResponse.code());
        assertEquals("unauthorized", authFail.getId());
        assertEquals("Unable to authenticate you.", authFail.getMessage());
    }

    @Test
    public void testSuccess() throws Exception {
        final SuccessAccountService successAccountService = new SuccessAccountService(behaviorDelegate);

        final Call<AccountResponse> accountCall = successAccountService.account();
        final Response<AccountResponse> accountResponse = accountCall.execute();
        assertTrue(accountResponse.isSuccessful());

        final AccountResponse response = accountResponse.body();
        assertNotNull(response);

        final Account account = response.getAccount();
        assertEquals(200, accountResponse.code());
        assertEquals(5, account.getDropletLimit());
        assertEquals(3, account.getFloatingIpLimit());
        assertEquals("test@test.com", account.getEmail());
        assertEquals("54t6921e147676342f17e6238111097b920dc0dd", account.getUuid());
        assertTrue(account.isVerified());
        assertEquals("active", account.getStatus());
        assertEquals("", account.getStatusMessage());
    }

    @After
    public void tearDown() throws Exception {
        retrofit = null;
        mockRetrofit = null;
        behaviorDelegate = null;
    }
}