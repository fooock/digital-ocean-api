package com.fooock.digital.ocean.image;

import com.fooock.digital.ocean.BaseTestService;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 *
 */
public class ImageServiceTest extends BaseTestService<ImageService> {

    public ImageServiceTest() {
        super(ImageService.class);
    }

    @Test
    public void testEmptyImages() throws Exception {
        final EmptyImageService emptyImageService = new EmptyImageService(behaviorDelegate);
        final Call<ImagesResponse> responseCall = emptyImageService.all();
        final Response<ImagesResponse> response = responseCall.execute();
        assertTrue(response.isSuccessful());

        final ImagesResponse imagesResponse = response.body();
        assertNotNull(imagesResponse);
        assertEquals(0, imagesResponse.metadata().total());
        assertEquals(0, imagesResponse.images().size());
        assertFalse(imagesResponse.links().hasPages());
    }

    @Test
    public void testOneImage() throws Exception {
        final OneImageService oneImageService = new OneImageService(behaviorDelegate);
        final Call<ImagesResponse> responseCall = oneImageService.all();
        final Response<ImagesResponse> response = responseCall.execute();
        assertTrue(response.isSuccessful());

        final ImagesResponse imagesResponse = response.body();
        assertNotNull(imagesResponse);
        assertEquals(1, imagesResponse.metadata().total());
        assertFalse(imagesResponse.links().hasPages());

        final Image image = imagesResponse.images().get(0);
        assertNotNull(image);
        assertEquals(27126923, image.id());
        assertEquals("1492.5.0 (beta)", image.name());
        assertEquals("CoreOS", image.distribution());
        assertEquals("coreos-beta", image.slug());
        assertTrue(image.isPublic());
        assertEquals(12, image.regions().size());
        assertEquals(20, image.minDiskSize());
        assertEquals("snapshot", image.type());
        assertEquals(0.34, image.size(), 0.001);
    }

    @Test
    public void testMultipleImages() throws Exception {
        final AllImageService allImageService = new AllImageService(behaviorDelegate);
        final Call<ImagesResponse> responseCall = allImageService.all();
        final Response<ImagesResponse> response = responseCall.execute();
        assertTrue(response.isSuccessful());

        final ImagesResponse imagesResponse = response.body();
        assertNotNull(imagesResponse);
        assertEquals(93, imagesResponse.metadata().total());
        assertEquals(20, imagesResponse.images().size());
        assertTrue(imagesResponse.links().hasPages());
    }
}