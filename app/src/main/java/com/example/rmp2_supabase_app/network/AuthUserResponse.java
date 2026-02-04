package com.example.rmp2_supabase_app.network;

public class AuthUserResponse {

    private String access_token;
    private User user;

    public String getAccess_token() {
        return access_token;
    }

    public String getUserId() {
        return user.getId();
    }
}

class User {
    private String id;

    public String getId() {
        return id;
    }
}
