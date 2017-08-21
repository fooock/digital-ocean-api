package com.fooock.digital.ocean.image;

/**
 * Response object for the methods inside the {@link ImageService}
 */
public class ImageResponse {

    private final Image image;

    /**
     * Create this object
     *
     * @param image {@link Image}
     */
    public ImageResponse(Image image) {
        this.image = image;
    }

    public Image image() {
        return image;
    }
}
