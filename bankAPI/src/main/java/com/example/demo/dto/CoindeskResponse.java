package com.example.demo.dto;

import java.sql.Time;
import java.util.Map;

public class CoindeskResponse {
	
	private Time time;
	public static class Time{
		private String updatedISO;
		public Time(String updatedISO) {
			this.updatedISO = updatedISO;
		}
		public Time() {
			
		}
		public String getUpdatedISO() {
			return updatedISO;
		}
		public void setUpdatedISO(String updatedISO) {
			this.updatedISO = updatedISO;
		}
	}
	
	public static class Detail {
		private String rate;

		public Detail(String rate) {
			this.rate = rate;
		}
		public Detail() {
			
		}

		public String getRate() {
			return rate;
		}
		public void setRate(String rate) {
			this.rate = rate;
		}
	}
	
	private Map<String, Detail> detail;

	public CoindeskResponse(Time time, Map<String, Detail> detail) {
		this.time = time;
		this.detail = detail;
	}

	public CoindeskResponse() {
		
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Map<String, Detail> getDetail() {
		return detail;
	}

	public void setDetail(Map<String, Detail> detail) {
		this.detail = detail;
	}
	
	

}
