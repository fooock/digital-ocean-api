package com.fooock.digital.ocean.size;

import com.fooock.digital.ocean.Metadata;

import java.util.List;

/**
 * Response object for the {@link SizeService#all()} method
 */
public class SizeResponse {

    private final Metadata meta;
    private final List<Size> sizes;

    /**
     * Create this object
     *
     * @param meta  Response {@link Metadata}
     * @param sizes List of {@link Size}s
     */
    public SizeResponse(Metadata meta, List<Size> sizes) {
        this.meta = meta;
        this.sizes = sizes;
    }

    /**
     * @return Metadata for this response
     */
    public Metadata metadata() {
        return meta;
    }

    /**
     * @return List of sizes
     */
    public List<Size> sizes() {
        return sizes;
    }
}
