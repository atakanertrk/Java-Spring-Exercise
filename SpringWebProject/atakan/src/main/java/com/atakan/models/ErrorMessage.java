package com.atakan.models;

import java.util.Date;

public class ErrorMessage {
	private String time;
	private String message;
	
	public ErrorMessage(String time, String message) {
		this.time = time;
		this.message = message;
	}
	public ErrorMessage() {
	}
	public String getTimestamp() {
		return time;
	}
	public void setTimestamp(String time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
