package com.oxingaxin.ticker.model;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public abstract class ApiResponse<T> {
    protected final Map<String, Object> metadata;
    protected final T data;
}
