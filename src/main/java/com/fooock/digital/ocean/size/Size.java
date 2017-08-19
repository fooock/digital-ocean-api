package com.fooock.digital.ocean.size;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This object represent different packages of hardware resources that can be used for Droplets.
 * When a Droplet is created, a size must be selected so that the correct resources can be allocated.
 * <p>
 * Each size represents a plan that bundles together specific sets of resources. This includes the amount of RAM,
 * the number of virtual CPUs, disk space, and transfer. The size object also includes the pricing details and
 * the regions that the size is available in.
 */
public class Size {

    private final boolean available;

    private final double transfer;
    @SerializedName("price_monthly")
    private final double priceMonthly;
    @SerializedName("price_hourly")
    private final double priceHourly;

    private final int memory;
    @SerializedName("vcpus")
    private final int cpus;
    private final int disk;

    private final String slug;

    private final List<String> regions;

    /**
     * Create this object
     *
     * @param available    This is a boolean value that represents whether new Droplets can be created with this size.
     * @param transfer     The amount of transfer bandwidth that is available for Droplets created in this size.
     *                     This only counts traffic on the public interface. The value is given in terabytes.
     * @param priceMonthly This attribute describes the monthly cost of this Droplet size if the Droplet is
     *                     kept for an entire month. The value is measured in US dollars.
     * @param priceHourly  This describes the price of the Droplet size as measured hourly.
     *                     The value is measured in US dollars.
     * @param memory       The amount of RAM allocated to Droplets created of this size. The value is
     *                     represented in megabytes.
     * @param cpus         The number of virtual CPUs allocated to Droplets of this size.
     * @param disk         The amount of disk space set aside for Droplets of this size. The value is represented
     *                     in gigabytes.
     * @param slug         A human-readable string that is used to uniquely identify each size.
     * @param regions      An array containing the region slugs where this size is available for Droplet creates.
     */
    public Size(boolean available, double transfer, double priceMonthly, double priceHourly,
                int memory, int cpus, int disk, String slug, List<String> regions) {
        this.available = available;
        this.transfer = transfer;
        this.priceMonthly = priceMonthly;
        this.priceHourly = priceHourly;
        this.memory = memory;
        this.cpus = cpus;
        this.disk = disk;
        this.slug = slug;
        this.regions = regions;
    }

    /**
     * This is a boolean value that represents whether new Droplets can be created with this size.
     *
     * @return True if Droplet can be created with this size, false if not
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @return The amount of transfer bandwidth that is available for Droplets created in this size.
     * This only counts traffic on the public interface. The value is given in terabytes.
     */
    public double transferBandwidth() {
        return transfer;
    }

    /**
     * @return This attribute describes the monthly cost of this Droplet size if the Droplet is
     * kept for an entire month. The value is measured in US dollars.
     */
    public double priceMonthly() {
        return priceMonthly;
    }

    /**
     * @return This describes the price of the Droplet size as measured hourly.
     * The value is measured in US dollars.
     */
    public double priceHourly() {
        return priceHourly;
    }

    /**
     * @return The amount of RAM allocated to Droplets created of this size. The value is
     * represented in megabytes.
     */
    public int memory() {
        return memory;
    }

    /**
     * @return The number of virtual CPUs allocated to Droplets of this size.
     */
    public int cpus() {
        return cpus;
    }

    /**
     * @return The amount of disk space set aside for Droplets of this size. The value is represented in gigabytes.
     */
    public int disk() {
        return disk;
    }

    /**
     * @return A human-readable string that is used to uniquely identify each size.
     */
    public String slug() {
        return slug;
    }

    /**
     * @return An array containing the region slugs where this size is available for Droplet creates.
     */
    public List<String> regions() {
        return regions;
    }
}
