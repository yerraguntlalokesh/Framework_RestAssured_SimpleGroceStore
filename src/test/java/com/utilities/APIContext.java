package com.utilities;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public final class APIContext {

    private static final ThreadLocal<Map<String, Object>> context = new ThreadLocal<>();

    private APIContext() {

    }

    public static void set(String key, Object value) {

        Map<String, Object> data = context.get();

        if (data == null) {
            data = new HashMap<>();
            context.set(data);
        }

        data.put(key, value);
    }

    public static Object get(String key) {

        Map<String, Object> data = context.get();

        if (data == null) {
            return null;
        }

        return data.get(key);
    }

    /* ===========================
       Reporting Methods
       =========================== */

    public static void setResponse(Response response) {

        if (response == null) {
            return;
        }

        set("statusCode", response.getStatusCode());
        set("responseTime", response.time());

    }

    public static Integer getStatusCode() {

        return (Integer) get("statusCode");

    }

    public static Long getResponseTime() {

        return (Long) get("responseTime");

    }

    public static void clear() {

        Map<String, Object> data = context.get();

        if (data != null) {
            data.clear();
        }

        context.remove();
    }
}