package com.qalex.m7md.task.Model;

import com.google.gson.annotations.SerializedName;



public class User {
    @SerializedName("login")
    private String logIn;
    @SerializedName("id")
    private String id;
    @SerializedName("avatar_url")
    private String avatarURL;
    @SerializedName("gravatar_id")
    private String gravtarID;
    @SerializedName("url")
    private String url;
    @SerializedName("html_url")
    private String htmlURL;
    @SerializedName("followers_url")
    private String followersURL;
    @SerializedName("following_url")
    private String followingURL;
    @SerializedName("gists_url")
    private String gistsURL;
    @SerializedName("starred_url")
    private String starredURL;
    @SerializedName("subscriptions_url")
    private String subscriptionsURL;
    @SerializedName("organizations_url")
    private String organizationsURL;
    @SerializedName("repos_url")
    private String reposURL;
    @SerializedName("events_url")
    private String eventsURL;
    @SerializedName("received_events_url")
    private String received_eventsURL;
    @SerializedName("type")
    private String type;
    @SerializedName("site_admin")
    private Boolean site_admin;



    public User(String logIn, String id, String avatarURL, String gravtarID, String url,
                String htmlURL, String followersURL, String followingURL, String gistsURL, String starredURL,
                String subscriptionsURL, String organizationsURL, String reposURL, String eventsURL, String received_eventsURL,
                String type, Boolean site_admin) {
        this.logIn = logIn;
        this.id = id;
        this.avatarURL = avatarURL;
        this.gravtarID = gravtarID;
        this.url = url;
        this.htmlURL = htmlURL;
        this.followersURL = followersURL;
        this.followingURL = followingURL;
        this.gistsURL = gistsURL;
        this.starredURL = starredURL;
        this.subscriptionsURL = subscriptionsURL;
        this.organizationsURL = organizationsURL;
        this.reposURL = reposURL;
        this.eventsURL = eventsURL;
        this.received_eventsURL = received_eventsURL;
        this.type = type;
        this.site_admin = site_admin;
    }

    public String getLogIn() {
        return logIn;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getGravtarID() {
        return gravtarID;
    }

    public void setGravtarID(String gravtarID) {
        this.gravtarID = gravtarID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlURL() {
        return htmlURL;
    }

    public void setHtmlURL(String htmlURL) {
        this.htmlURL = htmlURL;
    }

    public String getFollowersURL() {
        return followersURL;
    }

    public void setFollowersURL(String followersURL) {
        this.followersURL = followersURL;
    }

    public String getFollowingURL() {
        return followingURL;
    }

    public void setFollowingURL(String followingURL) {
        this.followingURL = followingURL;
    }

    public String getGistsURL() {
        return gistsURL;
    }

    public void setGistsURL(String gistsURL) {
        this.gistsURL = gistsURL;
    }

    public String getStarredURL() {
        return starredURL;
    }

    public void setStarredURL(String starredURL) {
        this.starredURL = starredURL;
    }

    public String getSubscriptionsURL() {
        return subscriptionsURL;
    }

    public void setSubscriptionsURL(String subscriptionsURL) {
        this.subscriptionsURL = subscriptionsURL;
    }

    public String getOrganizationsURL() {
        return organizationsURL;
    }

    public void setOrganizationsURL(String organizationsURL) {
        this.organizationsURL = organizationsURL;
    }

    public String getEventsURL() {
        return eventsURL;
    }

    public void setEventsURL(String eventsURL) {
        this.eventsURL = eventsURL;
    }

    public String getReposURL() {
        return reposURL;
    }

    public void setReposURL(String reposURL) {
        this.reposURL = reposURL;
    }

    public String getReceived_eventsURL() {
        return received_eventsURL;
    }

    public void setReceived_eventsURL(String received_eventsURL) {
        this.received_eventsURL = received_eventsURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSite_admin() {
        return site_admin;
    }

    public void setSite_admin(Boolean site_admin) {
        this.site_admin = site_admin;
    }
}

