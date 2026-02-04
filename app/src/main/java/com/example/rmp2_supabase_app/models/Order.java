package com.example.rmp2_supabase_app.models;

import com.google.gson.annotations.SerializedName;

public class Order {
    private long id;
    @SerializedName("created_at")
    private String createdAt;
    private String title;
    private float cost;
    @SerializedName("user_id")
    private String userId;

    public long getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getTitle() {
        return title;
    }

    public float getCost() {
        return cost;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdAt='" + createdAt + '\n' +
                ", title='" + title + '\n' +
                ", cost=" + cost + '\n' +
                ", userId='" + userId + '\n' +
                '}';
    }
}
