package com.ilearn.restTemplate;

import java.util.ArrayList;
import java.util.Properties;

/**
 * https://www.site24x7.com/tools/json-to-java.html curl
 * localhost:8888/foo/development { "name":"foo", "label":"master",
 * "propertySources":[ {
 * "name":"https://github.com/scratches/config-repo/foo-development.properties",
 * "source":{"bar":"spam"} }, {
 * "name":"https://github.com/scratches/config-repo/foo.properties",
 * "source":{"foo":"bar"} } ]}
 * 
 * @author ADMIN
 *
 */
public class PropertiesPojo {

	private String name;
	ArrayList<Object> profiles = new ArrayList<Object>();
	private String label = null;
	private String version;
	private String state = null;

	public ArrayList<Object> getProfiles() {
		return profiles;
	}

	public void setProfiles(ArrayList<Object> profiles) {
		this.profiles = profiles;
	}

	ArrayList<PropertySource> propertySources = new ArrayList<PropertySource>();

	// Getter Methods

	public ArrayList<PropertySource> getPropertySources() {
		return propertySources;
	}

	public void setPropertySources(ArrayList<PropertySource> propertySources) {
		this.propertySources = propertySources;
	}

	public String getName() {
		return name;
	}

	public String getLabel() {
		return label;
	}

	public String getVersion() {
		return version;
	}

	public String getState() {
		return state;
	}

	// Setter Methods

	public void setName(String name) {
		this.name = name;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "PropertiesPojo [name=" + name + ", profiles=" + profiles + ", label=" + label + ", version=" + version
				+ ", state=" + state + ", propertySources=" + propertySources + "]";
	}
	
	public Properties getAllProperties() {
		Properties result = new Properties();		
		for (PropertySource source: propertySources) {
			return source.getProperties();			
		}
		return result;
	}

}

class PropertySource {

	@Override
	public String toString() {
		return "PropertySource [name=" + name + ", sourceObject=" + sourceObject + "]";
	}

	Properties getProperties() {
		Properties result = new Properties();
		String str = sourceObject.toString().trim(); //str={username=usernameValue, password=passwordValue}				
		str = str.substring(1, str.length()-1).trim();
		String[] properties = str.split(",");
		for(String property: properties) {
			String[] str2 = property.trim().split("=");
			PropertyVO vo = new PropertyVO(str2[0], str2[1]);
			result.put(vo.getKey(), vo.getValue());
		}
		return result;
		
	}

	private String name;
	Object sourceObject;

	// Getter Methods
	public String getName() {
		return name;
	}

	public Object getSource() {
		return sourceObject;
	}

	// Setter Methods
	public void setName(String name) {
		this.name = name;
	}

	public void setSource(Object sourceObject) {
		this.sourceObject = sourceObject;
	}
}
