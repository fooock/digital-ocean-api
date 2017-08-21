package com.fooock.digital.ocean.action;

import com.fooock.digital.ocean.BaseTestService;
import com.fooock.digital.ocean.ResponseError;
import okhttp3.ResponseBody;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;

import java.lang.annotation.Annotation;

import static org.junit.Assert.*;

public class ActionServiceTest extends BaseTestService<ActionService> {

    public ActionServiceTest() {
        super(ActionService.class);
    }

    @Test
    public void testSuccessEmptyActions() throws Exception {
        final EmptyActionService emptyActionService = new EmptyActionService(behaviorDelegate);

        final Call<ActionsResponse> actionsResponseCall = emptyActionService.all();
        final Response<ActionsResponse> response = actionsResponseCall.execute();
        assertTrue(response.isSuccessful());

        final ActionsResponse actionsResponse = response.body();
        assertNotNull(actionsResponse);

        assertEquals(0, actionsResponse.metadata().total());
        assertNotNull(actionsResponse.links());
        assertFalse(actionsResponse.links().hasPages());
        assertNull(actionsResponse.links().pages());
        assertNotNull(actionsResponse.actions());
        assertEquals(0, actionsResponse.actions().size());
    }

    @Test
    public void testSuccessSingleAction() throws Exception {
        final SingleActionService singleActionService = new SingleActionService(behaviorDelegate);

        final Call<ActionsResponse> actionsResponseCall = singleActionService.all();
        final Response<ActionsResponse> response = actionsResponseCall.execute();
        assertTrue(response.isSuccessful());

        final ActionsResponse actionsResponse = response.body();
        assertNotNull(actionsResponse);

        assertEquals(159, actionsResponse.metadata().total());

        assertNotNull(actionsResponse.links());
        assertTrue(actionsResponse.links().hasPages());
        assertNotNull(actionsResponse.links().pages());
        assertTrue(actionsResponse.links().pages().hasLast());
        assertEquals("https://api.digitalocean.com/v2/actions?page=159&per_page=1",
                actionsResponse.links().pages().last());
        assertTrue(actionsResponse.links().pages().hasNext());
        assertEquals("https://api.digitalocean.com/v2/actions?page=2&per_page=1",
                actionsResponse.links().pages().next());
        assertFalse(actionsResponse.links().pages().hasFirst());
        assertNull(actionsResponse.links().pages().first());
        assertFalse(actionsResponse.links().pages().hasPrevious());
        assertNull(actionsResponse.links().pages().previous());

        assertEquals(1, actionsResponse.actions().size());
        final Action action = actionsResponse.actions().get(0);
        assertEquals(36804636, action.id());
        assertEquals("completed", action.status());
        assertEquals("create", action.type());
        assertEquals(3164444, action.resourceId());
        assertEquals("droplet", action.resourceType());
        assertEquals("nyc3", action.region());
    }

    @Test
    public void testSuccessGetOneAction() throws Exception {
        final SingleActionService singleActionService = new SingleActionService(behaviorDelegate);

        final Call<ActionResponse> actionsResponseCall = singleActionService.get(1);
        final Response<ActionResponse> response = actionsResponseCall.execute();
        assertTrue(response.isSuccessful());

        final ActionResponse actionResponse = response.body();
        assertNotNull(actionResponse);

        final Action action = actionResponse.action();
        assertEquals(36804636, action.id());
        assertEquals("completed", action.status());
        assertEquals("create", action.type());
        assertEquals(3164444, action.resourceId());
        assertEquals("droplet", action.resourceType());
        assertEquals("nyc3", action.region());
    }

    @Test
    public void testSuccessMultipleActions() throws Exception {
        final MultipleActionService multipleActionService = new MultipleActionService(behaviorDelegate);

        final Call<ActionsResponse> actionsResponseCall = multipleActionService.all();
        final Response<ActionsResponse> response = actionsResponseCall.execute();
        assertTrue(response.isSuccessful());

        final ActionsResponse actionsResponse = response.body();
        assertNotNull(actionsResponse);

        assertEquals(15912, actionsResponse.metadata().total());

        assertNotNull(actionsResponse.links());
        assertTrue(actionsResponse.links().hasPages());
        assertNotNull(actionsResponse.links().pages());

        assertTrue(actionsResponse.links().pages().hasLast());
        assertEquals("https://api.digitalocean.com/v2/actions?page=159&per_page=1",
                actionsResponse.links().pages().last());

        assertTrue(actionsResponse.links().pages().hasNext());
        assertEquals("https://api.digitalocean.com/v2/actions?page=5&per_page=1",
                actionsResponse.links().pages().next());

        assertTrue(actionsResponse.links().pages().hasFirst());
        assertEquals("https://api.digitalocean.com/v2/actions?page=1&per_page=1",
                actionsResponse.links().pages().first());

        assertTrue(actionsResponse.links().pages().hasPrevious());
        assertEquals("https://api.digitalocean.com/v2/actions?page=3&per_page=1",
                actionsResponse.links().pages().previous());

        assertEquals(3, actionsResponse.actions().size());
    }

    @Test
    public void testFailActionNotFound() throws Exception {
        final NotFoundActionService notFoundActionService = new NotFoundActionService(behaviorDelegate);
        final Call<ActionResponse> responseCall = notFoundActionService.get(-1);
        final Response<ActionResponse> response = responseCall.execute();
        assertFalse(response.isSuccessful());

        final Converter<ResponseBody, ResponseError> bodyConverter = retrofit.responseBodyConverter(
                ResponseError.class, new Annotation[0]);
        final ResponseError responseError = bodyConverter.convert(response.errorBody());

        assertEquals(404, response.code());
        assertEquals("not_found", responseError.id());
        assertEquals("The resource you were accessing could not be found.",
                responseError.message());
    }
}