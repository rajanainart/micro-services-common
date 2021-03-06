package com.rajanainart.rest;

import java.util.ArrayList;
import java.util.List;

import com.rajanainart.data.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RestMessageEntity extends BaseEntity {
    public enum MessageStatus { SUCCESS, FAILURE }
    private String id = "";
    private String description = "";
    private MessageStatus status = MessageStatus.SUCCESS;
    private int generatedId  ;
        	
	@JsonProperty("msgId")
    public String getErrorId() { return id; }
    public String getDescription() { return description; }
    public MessageStatus getStatus() { return status; }
    public int getGeneratedId() {
		return generatedId;
	}

    public void setStatus(MessageStatus status) { this.status = status; }
    public void setErrorId(String id) { this.id = id; }
    public void setDescription(String desc) { this.description = desc; }
    public void setGeneratedId(int generatedId) {
		this.generatedId = generatedId;
	}

    private RestMessageEntity() {}

    public static BaseEntity getInstance(String id, String desc) {
        RestMessageEntity instance = new RestMessageEntity();
        instance.setErrorId(id);
        instance.setDescription(desc);
        return instance;
    }

    public static BaseEntity getInstance(String id, String desc, MessageStatus status) {
        RestMessageEntity instance = new RestMessageEntity();
        instance.setErrorId(id);
        instance.setDescription(desc);
        instance.setStatus(status);
        return instance;
    }
    
    public static BaseEntity getInstance(String id, String desc, MessageStatus status,int generatedId) {
        RestMessageEntity instance = new RestMessageEntity();
        instance.setErrorId(id);
        instance.setDescription(desc);
        instance.setStatus(status);
        instance.setGeneratedId(generatedId);
        return instance;
    }

    public static List<BaseEntity> getInstanceList(String id, String desc) {
        List<BaseEntity> list = new ArrayList<>();
        list.add(getInstance(id, desc));
        return list;
    }

    public static List<BaseEntity> getInstanceList(String id, String desc, MessageStatus status) {
        List<BaseEntity> list = new ArrayList<>();
        list.add(getInstance(id, desc, status));
        return list;
    }
}