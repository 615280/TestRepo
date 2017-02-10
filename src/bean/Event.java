/*
 * @(#) Event.java Aug 1, 2016
 * 
 * Copyright 2010 NetEase.com, Inc. All rights reserved.
 */
package bean;

/**
 *
 * @author hzwangwenlong
 * @version Aug 1, 2016
 */
public class Event {

    private int id;

    private String name;

    private String cname;

    private boolean visible;

    private boolean virtual;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }
}
