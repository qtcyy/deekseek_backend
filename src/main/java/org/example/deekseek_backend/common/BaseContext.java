package org.example.deekseek_backend.common;

/**
 * @author chengyiyang
 */
public class BaseContext {
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static String getCurrentId() {
        return THREAD_LOCAL.get();
    }

    public static void setCurrentId(String id) {
        THREAD_LOCAL.set(id);
    }

    public static void clear() {
        THREAD_LOCAL.remove();
    }
}
