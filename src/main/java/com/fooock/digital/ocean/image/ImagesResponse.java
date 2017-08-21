package com.fooock.digital.ocean.image;

import com.fooock.digital.ocean.Links;
import com.fooock.digital.ocean.Metadata;

import java.util.List;

/**
 * Response object for the methods inside the {@link ImageService}
 */
public class ImagesResponse {

    private final Metadata meta;
    private final Links links;
    private final List<Image> images;

    /**
     * Create this object
     *
     * @param meta   Metadata for this response
     * @param links  Links for this response
     * @param images List of images
     */
    public ImagesResponse(Metadata meta, Links links, List<Image> images) {
        this.meta = meta;
        this.links = links;
        this.images = images;
    }

    /**
     * @return Metadata for this response
     */
    public Metadata metadata() {
        return meta;
    }

    /**
     * @return Links for this response. Can be empty
     */
    public Links links() {
        return links;
    }

    /**
     * @return List of images
     */
    public List<Image> images() {
        return images;
    }
}
