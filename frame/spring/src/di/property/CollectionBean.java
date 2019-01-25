package di.property;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private Set<String> set;
	private List<String> list;
	private Map<String, String> map;
	private Properties properties;


	public void setSet(Set<String> set) {
		this.set = set;
	}


	public void setList(List<String> list) {
		this.list = list;
	}


	public void setMap(Map<String, String> map) {
		this.map = map;
	}


	public void setProperties(Properties properties) {
		this.properties = properties;
	}


	@Override
	public String toString() {
		return "CollectionBean [set=" + set + ", list=" + list + ", map=" + map + ", properties=" + properties + "]";
	}
}
