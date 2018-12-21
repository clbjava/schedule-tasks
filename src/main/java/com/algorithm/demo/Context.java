package com.algorithm.demo;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Title: schedule-tasks
 * @Description: TODO
 * @author: Administrator
 * @date: 2018-12-21 16:54
 * @version: 1.0.0
 */
public class Context implements Map<String, Object> {

    private final Map<String, Object> context = new ConcurrentHashMap<String, Object>(16);

    private Common common;

    public Common getCommon() {
        return (Common) context.get("common");
    }

    public void setCommon(Common common) {
        //this.common = common;
        context.put("common",common);
    }

    @Override
    public int size() {
        return context.size();
    }

    @Override
    public boolean isEmpty() {
        return context.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return context.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return context.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return context.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        return context.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return context.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        context.putAll(m);
    }

    @Override
    public void clear() {
        context.clear();
    }

    @Override
    public Set<String> keySet() {
        return context.keySet();
    }

    @Override
    public Collection<Object> values() {
        return context.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return context.entrySet();
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return context.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super String, ? super Object> action) {
        context.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super String, ? super Object, ?> function) {
        context.replaceAll(function);
    }

    @Override
    public Object putIfAbsent(String key, Object value) {
        return context.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return context.remove(key, value);
    }

    @Override
    public boolean replace(String key, Object oldValue, Object newValue) {
        return context.replace(key, oldValue, newValue);
    }

    @Override
    public Object replace(String key, Object value) {
        return context.replace(key, value);
    }

    @Override
    public Object computeIfAbsent(String key, Function<? super String, ?> mappingFunction) {
        return context.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public Object computeIfPresent(String key, BiFunction<? super String, ? super Object, ?> remappingFunction) {
        return context.computeIfPresent(key, remappingFunction);
    }

    @Override
    public Object compute(String key, BiFunction<? super String, ? super Object, ?> remappingFunction) {
        return context.compute(key, remappingFunction);
    }

    @Override
    public Object merge(String key, Object value, BiFunction<? super Object, ? super Object, ?> remappingFunction) {
        return context.merge(key, value, remappingFunction);
    }
}
