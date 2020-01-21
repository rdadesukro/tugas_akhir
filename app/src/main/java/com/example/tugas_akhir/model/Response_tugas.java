package com.example.tugas_akhir.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Response_tugas {

	@SerializedName("result")
	private List<ResultItem_tugas> result;

	@SerializedName("status")
	private boolean status;

	@SerializedName("desc")
	private String desc;

	public void setResult(List<ResultItem_tugas> result){
		this.result = result;
	}

	public List<ResultItem_tugas> getResult(){
		return result;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}

	public String getDesc(){
		return desc;
	}

	@Override
 	public String toString(){
		return 
			"Response_tugas{" +
			"result = '" + result + '\'' + 
			",status = '" + status + '\'' + 
			",desc = '" + desc + '\'' + 
			"}";
		}
}