package com.example.assignment.model;

import com.google.gson.annotations.JsonAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Attribute implements Serializable {

    private final static long serialVersionUID = 9014571030364527534L;
    private String uuid;
    private long createdOn;
    private long lastModified;
    private String label;
    private String hint;
    private String key;
    private long order;
    private String type;
    private List<Object> attributeOptions = new ArrayList<Object>();
    private boolean required;

    /**
     * No args constructor for use in serialization
     */
    public Attribute() {
    }

    /**
     * @param hint
     * @param attributeOptions
     * @param lastModified
     * @param label
     * @param type
     * @param uuid
     * @param createdOn
     * @param key
     * @param required
     * @param order
     */
    public Attribute(String uuid, int createdOn, int lastModified, String label, String hint, String key, int order, String type, List<Object> attributeOptions, boolean required) {
        super();
        this.uuid = uuid;
        this.createdOn = createdOn;
        this.lastModified = lastModified;
        this.label = label;
        this.hint = hint;
        this.key = key;
        this.order = order;
        this.type = type;
        this.attributeOptions = attributeOptions;
        this.required = required;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Attribute withUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(int createdOn) {
        this.createdOn = createdOn;
    }

    public Attribute withCreatedOn(int createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(int lastModified) {
        this.lastModified = lastModified;
    }

    public Attribute withLastModified(int lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attribute withLabel(String label) {
        this.label = label;
        return this;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Attribute withHint(String hint) {
        this.hint = hint;
        return this;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Attribute withKey(String key) {
        this.key = key;
        return this;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Attribute withOrder(int order) {
        this.order = order;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attribute withType(String type) {
        this.type = type;
        return this;
    }

    public List<Object> getAttributeOptions() {
        return attributeOptions;
    }

    public void setAttributeOptions(List<Object> attributeOptions) {
        this.attributeOptions = attributeOptions;
    }

    public Attribute withAttributeOptions(List<Object> attributeOptions) {
        this.attributeOptions = attributeOptions;
        return this;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Attribute withRequired(boolean required) {
        this.required = required;
        return this;
    }

}