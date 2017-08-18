package com.fooock.digital.ocean.region;

import com.fooock.digital.ocean.BaseTestService;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class RegionServiceTest extends BaseTestService<RegionService> {

    public RegionServiceTest() {
        super(RegionService.class);
    }

    @Test
    public void testSuccess() throws Exception {
        final SuccessRegionService successRegionService = new SuccessRegionService(behaviorDelegate);
        final Call<RegionsResponse> regionsResponseCall = successRegionService.all();
        final Response<RegionsResponse> response = regionsResponseCall.execute();
        assertTrue(response.isSuccessful());

        final RegionsResponse regionsResponse = response.body();
        assertNotNull(regionsResponse);
        assertEquals(9, regionsResponse.metadata().total());
        assertEquals(9, regionsResponse.regions().size());
    }

    @Test
    public void testOneRegion() throws Exception {
        final OneRegionService oneRegionService = new OneRegionService(behaviorDelegate);
        final Call<RegionsResponse> regionsResponseCall = oneRegionService.all();
        final Response<RegionsResponse> response = regionsResponseCall.execute();
        assertTrue(response.isSuccessful());

        final RegionsResponse regionsResponse = response.body();
        assertNotNull(regionsResponse);
        final List<Region> regions = regionsResponse.regions();
        assertTrue(regions.size() == 1);

        final Region region = regions.get(0);
        assertEquals("New York 3", region.name());
        assertEquals("nyc3", region.slug());
        assertTrue(region.isAvailable());
        assertTrue(region.sizes().size() == 9);
        assertTrue(region.features().size() == 5);
    }
}