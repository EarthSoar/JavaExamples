package di.constructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private Set<String> set;
	private List<String> list;
	private Map<String, String> map;
	private Properties properties;

	

	public CollectionBean(Set<String> set, Properties properties) {
		this.set = set;
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "CollectionBean [set=" + set + ", list=" + list + ", map=" + map + ", properties=" + properties + "]";
	}
}
