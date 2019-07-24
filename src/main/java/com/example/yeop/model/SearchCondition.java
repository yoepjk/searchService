package com.example.yeop.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SearchCondition {
	private String query;
	
	private int page;
	
	private int size;
}
