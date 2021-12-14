package com.wyjson.mvpdemo.entity;

import java.io.Serializable;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:55 PM
 */
public class UserEntity implements Serializable {

    private long id;
    private String name;

    public UserEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
