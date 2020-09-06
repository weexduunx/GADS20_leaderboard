package com.idyndiouck.gads_leaderbord2020.api;

public interface ApiResponseCallback<T> {
    void onResponse(T response);
    void onError(Throwable error);
}
