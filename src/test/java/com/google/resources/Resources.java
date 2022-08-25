package com.google.resources;

public enum Resources {
	
	 addPlaceApi("/maps/api/place/add/json"),
	 getPlaceApi("/maps/api/place/get/json"),
	 deletePlaceApi("/maps/api/place/delete/json");
	
	private String resource;
	
	Resources(String resources){
		
		this.resource = resources;
		
	}

	public String getResource(){
		return resource;
	}
	
}
