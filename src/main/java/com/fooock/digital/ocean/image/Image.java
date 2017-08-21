package com.fooock.digital.ocean.image;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Images in DigitalOcean may refer to one of a few different kinds of objects.
 * <p>
 * An image may refer to a snapshot that has been taken of a Droplet instance. It may also mean an
 * image representing an automatic backup of a Droplet. The third category that it can represent is
 * a public Linux distribution or application image that is used as a base to create Droplets.
 */
public class Image {

    @SerializedName("public")
    private final boolean publicImage;

    private final long id;

    @SerializedName("size_gigabytes")
    private final double size;

    @SerializedName("min_disk_size")
    private final int minDiskSize;

    private final String name;
    private final String type;
    private final String distribution;
    private final String slug;

    @SerializedName("created_at")
    private final Date createdAt;

    private final List<String> regions;

    /**
     * Create this object
     *
     * @param publicImage  This is a boolean value that indicates whether the image in question is public or not.
     *                     An image that is public is available to all accounts. A non-public image is only accessible
     *                     from your account.
     * @param id           A unique number that can be used to identify and reference a specific image.
     * @param minDiskSize  The minimum 'disk' required for a size to use this image.
     * @param size         The size of the image in gigabytes.
     * @param name         The display name that has been given to an image. This is what is shown in the control panel
     *                     and is generally a descriptive title for the image in question.
     * @param type         The kind of image, describing the duration of how long the image is stored. This is either
     *                     "snapshot" or "backup".
     * @param distribution This attribute describes the base distribution used for this image.
     * @param slug         A uniquely identifying string that is associated with each of the DigitalOcean-provided
     *                     public images. These can be used to reference a public image as an alternative to the
     *                     numeric id.
     * @param createdAt    A time value given in ISO8601 combined date and time format that represents when the
     *                     Image was created.
     * @param regions      This attribute is an array of the regions that the image is available in. The regions are
     *                     represented by their identifying slug values.
     */
    public Image(boolean publicImage, long id, int minDiskSize, double size, String name, String type,
                 String distribution, String slug, Date createdAt, List<String> regions) {
        this.publicImage = publicImage;
        this.id = id;
        this.minDiskSize = minDiskSize;
        this.size = size;
        this.name = name;
        this.type = type;
        this.distribution = distribution;
        this.slug = slug;
        this.createdAt = createdAt;
        this.regions = regions;
    }

    /**
     * @return This is a boolean value that indicates whether the image in question is public or not.
     * An image that is public is available to all accounts. A non-public image is only accessible
     * from your account.
     */
    public boolean isPublic() {
        return publicImage;
    }

    /**
     * @return A unique number that can be used to identify and reference a specific image.
     */
    public long id() {
        return id;
    }

    /**
     * @return The minimum 'disk' required for a size to use this image.
     */
    public int minDiskSize() {
        return minDiskSize;
    }

    /**
     * @return The size of the image in gigabytes.
     */
    public double size() {
        return size;
    }

    /**
     * @return The display name that has been given to an image. This is what is shown in the control panel
     * and is generally a descriptive title for the image in question.
     */
    public String name() {
        return name;
    }

    /**
     * @return The kind of image, describing the duration of how long the image is stored. This is either
     * "snapshot" or "backup".
     */
    public String type() {
        return type;
    }

    /**
     * @return This attribute describes the base distribution used for this image.
     */
    public String distribution() {
        return distribution;
    }

    /**
     * @return A uniquely identifying string that is associated with each of the DigitalOcean-provided
     * public images. These can be used to reference a public image as an alternative to the
     * numeric id. Can be null
     */
    public String slug() {
        return slug;
    }

    /**
     * @return A time value given in ISO8601 combined date and time format that represents when the
     * Image was created.
     */
    public Date createdAt() {
        return createdAt;
    }

    /**
     * @return This attribute is an array of the regions that the image is available in. The regions are
     * represented by their identifying slug values.
     */
    public List<String> regions() {
        return regions;
    }
}
