package com.idyndiouck.gads_leaderbord2020.data;

public interface DataResponseCallback<T> {
    void onResponse(T response);
    void onError(Throwable error);
}
