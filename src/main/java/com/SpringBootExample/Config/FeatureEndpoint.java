package com.SpringBootExample.Config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

/*
 * we are create the map that enable which feature enable and disable, we need to create the feature class[pojo]
 */


@Component
@Endpoint(id = "feature")
public class FeatureEndpoint {
	
	 private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();
	
	 
	 private  FeatureEndpoint() {
		
		 featureMap.put("Department", new Feature(true));
		 featureMap.put("User", new Feature(false));
		 featureMap.put("Authentication", new Feature(false));

	}
	 
	 @ReadOperation  //for reading , we have delete and writing as well
	 public Map<String, Feature> features() {
		
		 return featureMap; 
	}
	 
	 @ReadOperation 
	public Feature feature(@Selector  String featureName) {
		
		return featureMap.get(featureName);
	}
	 
	 
}
