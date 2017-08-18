package com.fooock.digital.ocean.account;

import com.fooock.digital.ocean.BaseTestService;
import com.fooock.digital.ocean.ResponseError;
import okhttp3.ResponseBody;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;

import java.lang.annotation.Annotation;

import static org.junit.Assert.*;

/**
 *
 */
public class AccountServiceTest extends BaseTestService<AccountService> {

    public AccountServiceTest() {
        super(AccountService.class);
    }

    @Test
    public void testUnauthorized() throws Exception {
        final FailAccountService failAccountService = new FailAccountService(behaviorDelegate);

        final Call<AccountResponse> account = failAccountService.account();
        final Response<AccountResponse> accountResponse = account.execute();
        assertFalse(accountResponse.isSuccessful());

        final Converter<ResponseBody, ResponseError> bodyConverter = retrofit.responseBodyConverter(
                ResponseError.class, new Annotation[0]);
        final ResponseError responseError = bodyConverter.convert(accountResponse.errorBody());

        assertEquals(401, accountResponse.code());
        assertEquals("unauthorized", responseError.getId());
        assertEquals("Unable to authenticate you.", responseError.getMessage());
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
}