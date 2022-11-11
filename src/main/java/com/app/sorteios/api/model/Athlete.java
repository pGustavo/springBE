package com.app.sorteios.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Athlete")
public class Athlete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long athlete_code;
	
	@Column(name = "group_category")
	private String groupCategory;
	
	@Column(name = "graduation")
	private String graduation;
	
	@Column(name = "weigth_category")
	private String weigthCategory;
	
	@Column(name = "category_type")
	private String categoryType;

  

	public Athlete() {
	}



	public long getAthlete_code() {
		return athlete_code;
	}



	public void setAthlete_code(long athlete_code) {
		this.athlete_code = athlete_code;
	}



	public String getGroupCategory() {
		return groupCategory;
	}



	public void setGroupCategory(String groupCategory) {
		this.groupCategory = groupCategory;
	}



	public String getGraduation() {
		return graduation;
	}



	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}



	public String getWeigthCategory() {
		return weigthCategory;
	}



	public void setWeigthCategory(String weigthCategory) {
		this.weigthCategory = weigthCategory;
	}



	public String getCategoryType() {
		return categoryType;
	}



	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	

}
