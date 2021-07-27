package com.oxingaxin.ticker.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public abstract class ApiResponse<T> {
    protected final T data;
    protected final Map<String, Object> metadata;
}
