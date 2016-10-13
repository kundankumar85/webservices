package com.learn.rest.model;

public class Profile {
	
	private Integer profileId;
	private String profileName;
	

	public Profile() {
		
	}

	

	public Profile(Integer profileId, String profileName) {
		super();
		this.profileId = profileId;
		this.profileName = profileName;
	}



	public Integer getProfileId() {
		return profileId;
	}


	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}


	public String getProfileName() {
		return profileName;
	}


	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	 

}
