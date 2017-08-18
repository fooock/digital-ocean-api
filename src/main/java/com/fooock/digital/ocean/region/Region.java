package com.fooock.digital.ocean.region;

import java.util.List;

/**
 * A region in DigitalOcean represents a datacenter where Droplets can be deployed and images can be transferred.
 * <p>
 * Each region represents a specific datacenter in a geographic location. Some geographical locations may
 * have multiple "regions" available. This means that there are multiple datacenters available within that area.
 */
public class Region {

    private final boolean available;

    private final String slug;
    private final String name;

    private final List<String> sizes;
    private final List<String> features;

    /**
     * Create this object
     *
     * @param available This is a boolean value that represents whether new Droplets can be created in this region
     * @param slug      A human-readable string that is used as a unique identifier for each region.
     * @param name      The display name of the region. This will be a full name that is used in the control
     *                  panel and other interfaces.
     * @param sizes     Contains the identifying slugs for the sizes available in this region.
     * @param features  Contains features available in this region
     */
    public Region(boolean available, String slug, String name, List<String> sizes, List<String> features) {
        this.available = available;
        this.slug = slug;
        this.name = name;
        this.sizes = sizes;
        this.features = features;
    }

    /**
     * This is a boolean value that represents whether new Droplets can be created in this region
     *
     * @return True if Droplets can be created, false if not
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @return A human-readable string that is used as a unique identifier for each region.
     */
    public String slug() {
        return slug;
    }

    /**
     * @return The display name of the region. This will be a full name that is used in the control
     */
    public String name() {
        return name;
    }

    /**
     * @return List that contains the identifying slugs for the sizes available in this region.
     */
    public List<String> sizes() {
        return sizes;
    }

    /**
     * @return List with the features available in this region
     */
    public List<String> features() {
        return features;
    }
}
