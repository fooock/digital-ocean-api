package com.fooock.digital.ocean.size;

import com.fooock.digital.ocean.BaseTestService;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class SizeServiceTest extends BaseTestService<SizeService> {

    public SizeServiceTest() {
        super(SizeService.class);
    }

    @Test
    public void testSuccess() throws Exception {
        final SuccessSizeService successSizeService = new SuccessSizeService(behaviorDelegate);
        final Call<SizeResponse> responseCall = successSizeService.all();
        final Response<SizeResponse> response = responseCall.execute();
        assertTrue(response.isSuccessful());

        final SizeResponse sizeResponse = response.body();
        assertNotNull(sizeResponse);
        assertEquals(9, sizeResponse.metadata().total());
        assertEquals(9, sizeResponse.sizes().size());
    }

    @Test
    public void testOneSuccess() throws Exception {
        final OneSizeService oneSizeService = new OneSizeService(behaviorDelegate);
        final Call<SizeResponse> responseCall = oneSizeService.all();
        final Response<SizeResponse> response = responseCall.execute();
        assertTrue(response.isSuccessful());

        final SizeResponse sizeResponse = response.body();
        assertNotNull(sizeResponse);
        assertEquals(1, sizeResponse.metadata().total());
        assertEquals(1, sizeResponse.sizes().size());

        final List<Size> sizes = sizeResponse.sizes();
        final Size size = sizes.get(0);
        assertEquals("512mb", size.slug());
        assertEquals(512, size.memory());
        assertEquals(1, size.cpus());
        assertEquals(20, size.disk());
        assertEquals(1.0, size.transferBandwidth(), 0.001);
        assertEquals(5.0, size.priceMonthly(), 0.001);
        assertEquals(0.00744, size.priceHourly(), 0.001);
        assertTrue(size.isAvailable());
        assertEquals(9, size.regions().size());
    }
}