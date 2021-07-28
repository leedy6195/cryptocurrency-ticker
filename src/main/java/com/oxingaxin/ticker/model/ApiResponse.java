package com.oxingaxin.ticker.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public abstract class ApiResponse<T, U> {
    protected final T data;
    protected final U metadata;
}
