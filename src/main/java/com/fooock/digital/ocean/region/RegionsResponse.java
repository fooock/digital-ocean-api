package com.fooock.digital.ocean.region;

import com.fooock.digital.ocean.Metadata;

import java.util.List;

/**
 * Response object for {@link RegionService#all()} method
 */
public class RegionsResponse {

    private final Metadata meta;
    private final List<Region> regions;

    /**
     * Create this object
     *
     * @param meta    Response metadata
     * @param regions List of regions
     */
    public RegionsResponse(Metadata meta, List<Region> regions) {
        this.meta = meta;
        this.regions = regions;
    }

    /**
     * @return Response {@link Metadata}
     */
    public Metadata metadata() {
        return meta;
    }

    /**
     * @return List of {@link Region}s
     */
    public List<Region> regions() {
        return regions;
    }
}
