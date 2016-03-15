package org.reuter.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.reuter.javabrains.messenger.database.DatabaseClass;
import org.reuter.javabrains.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("reuter" , new Profile(1L, "christoph", "reuter","Reuter"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(long id) {
		return profiles.get(id);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() +1) ;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(long id) {
		return profiles.remove(id);
	}
	
}
