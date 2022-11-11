package com.app.sorteios.api.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Athlete DTO class
 */
@Data
@NoArgsConstructor
public class Athlete {
    private String groupCategory;
    private String graduation;
    private List<Parameter> parameters;

    public Athlete(String groupCategory, String graduation) {
        this.groupCategory = groupCategory;
        this.graduation = graduation;
    }

    
    public static class Parameter {
        public Parameter(String promptText, String groupCategory, ParameterType parameterType) {
			// TODO Auto-generated constructor stub
		}

    }

    public enum ParameterType {
        INT, STRING
    }

	public List<Parameter> getParameters() {
		return parameters;
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

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	
	
}
