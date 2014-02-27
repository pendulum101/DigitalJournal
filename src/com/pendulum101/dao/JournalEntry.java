package com.pendulum101.dao;

public class JournalEntry {
	private String title = null;
	private String date = null;
	private String entryContents = null;
	private String mood = null;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEntryContents() {
		return entryContents;
	}
	public void setEntryContents(String entryContents) {
		this.entryContents = entryContents;
	}
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	
}
