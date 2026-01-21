package com.example.rmp2_supabase_app.callbacks;

public interface DataCallback<T> {
    void onLoad(T data);
}
