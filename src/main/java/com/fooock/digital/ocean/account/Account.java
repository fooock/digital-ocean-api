package com.fooock.digital.ocean.account;

import com.google.gson.annotations.SerializedName;

/**
 * Digital Ocean account info
 */
public final class Account {

    @SerializedName("email_verified")
    private final boolean verified;

    @SerializedName("droplet_limit")
    private final int dropletLimit;
    @SerializedName("floating_ip_limit")
    private final int floatingIpLimit;

    @SerializedName("status_message")
    private final String statusMessage;
    private final String email;
    private final String uuid;
    private final String status;

    /**
     * Create this object
     *
     * @param verified        If true, the user has verified their account via email. False otherwise.
     * @param dropletLimit    The total number of droplets the user may have
     * @param floatingIpLimit The total number of floating IPs the user may have
     * @param email           The email the user has registered for Digital Ocean with
     * @param uuid            The universal identifier for this user
     * @param status          This value is one of "active", "warning" or "locked".
     * @param statusMessage   A human-readable message giving more details about the status of the account.
     */
    public Account(boolean verified, int dropletLimit, int floatingIpLimit,
                   String email, String uuid, String status, String statusMessage) {
        this.verified = verified;
        this.dropletLimit = dropletLimit;
        this.floatingIpLimit = floatingIpLimit;
        this.email = email;
        this.uuid = uuid;
        this.status = status;
        this.statusMessage = statusMessage;
    }

    /**
     * @return If true, the user has verified their account via email. False otherwise.
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * @return The total number of droplets the user may have
     */
    public int dropletLimit() {
        return dropletLimit;
    }

    /**
     * @return The total number of floating IPs the user may have
     */
    public int floatingIpLimit() {
        return floatingIpLimit;
    }

    /**
     * @return The email the user has registered for Digital Ocean with
     */
    public String email() {
        return email;
    }

    /**
     * @return The universal identifier for this user
     */
    public String uuid() {
        return uuid;
    }

    /**
     * @return This value is one of "active", "warning" or "locked".
     */
    public String status() {
        return status;
    }

    /**
     * @return A human-readable message giving more details about the status of the account.
     */
    public String statusMessage() {
        return statusMessage;
    }
}
