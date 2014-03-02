package com.fei.exercicemaster.entity;

import java.util.Date;

public class ExerciseDetail {
	private int id;
	private String type;
	private String count;
	private Date createDate;

	public ExerciseDetail(int id, String type, String count, Date createDate) {
		this.id = id;
		this.type = type;
		this.count = count;
		this.createDate = createDate;
	}

	public ExerciseDetail(String type, String count, Date createDate) {
		this.type = type;
		this.count = count;
		this.createDate = createDate;
	}
	
	public ExerciseDetail() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
