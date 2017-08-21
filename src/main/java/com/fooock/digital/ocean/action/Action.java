package com.fooock.digital.ocean.action;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Actions are records of events that have occurred on the resources in your account. These can be things
 * like rebooting a Droplet, or transferring an image to a new region.
 * <p>
 * An action object is created every time one of these actions is initiated. The action object contains
 * information about the current status of the action, start and complete timestamps, and the associated
 * resource type and ID.
 */
public class Action {

    private final long id;
    @SerializedName("resource_id")
    private final long resourceId;

    private final String status;
    private final String type;
    @SerializedName("resource_type")
    private final String resourceType;
    @SerializedName("region_slug")
    private final String regionSlug;

    @SerializedName("started_at")
    private final Date startedAt;
    @SerializedName("completed_at")
    private final Date completedAt;

    /**
     * Create this object
     *
     * @param id           A unique numeric ID that can be used to identify and reference an action.
     * @param resourceId   A unique identifier for the resource that the action is associated with.
     * @param status       The current status of the action. This can be "in-progress", "completed", or "errored".
     * @param type         This is the type of action that the object represents. For example, this could be
     *                     "transfer" to represent the state of an image transfer action.
     * @param resourceType The type of resource that the action is associated with.
     * @param regionSlug   A slug representing the region where the action occurred. Can be {@code null}
     * @param startedAt    A time value given in ISO8601 combined date and time format that represents when the
     *                     action was initiated.
     * @param completedAt  A time value given in ISO8601 combined date and time format that represents when the
     *                     action was completed.
     */
    public Action(long id, long resourceId, String status, String type, String resourceType,
                  String regionSlug, Date startedAt, Date completedAt) {
        this.id = id;
        this.resourceId = resourceId;
        this.status = status;
        this.type = type;
        this.resourceType = resourceType;
        this.regionSlug = regionSlug;
        this.startedAt = startedAt;
        this.completedAt = completedAt;
    }

    /**
     * @return A unique numeric ID that can be used to identify and reference an action.
     */
    public long id() {
        return id;
    }

    /**
     * @return A unique identifier for the resource that the action is associated with.
     */
    public long resourceId() {
        return resourceId;
    }

    /**
     * @return The current status of the action. This can be "in-progress", "completed", or "errored".
     */
    public String status() {
        return status;
    }

    /**
     * @return This is the type of action that the object represents. For example, this could be
     * "transfer" to represent the state of an image transfer action.
     */
    public String type() {
        return type;
    }

    /**
     * @return The type of resource that the action is associated with.
     */
    public String resourceType() {
        return resourceType;
    }

    /**
     * @return A slug representing the region where the action occurred. Can be {@code null}
     */
    public String region() {
        return regionSlug;
    }

    /**
     * @return A time value given in ISO8601 combined date and time format that represents when the
     * action was initiated.
     */
    public Date startedAt() {
        return startedAt;
    }

    /**
     * @return A time value given in ISO8601 combined date and time format that represents when the
     * action was completed.
     */
    public Date completedAt() {
        return completedAt;
    }
}
