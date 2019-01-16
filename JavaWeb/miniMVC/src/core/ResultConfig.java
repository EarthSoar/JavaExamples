package core;

//封装<result>元素中的所有信息
public class ResultConfig {
	private String name;
	private String type;
	private String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ResultConfig(String name, String type, String path) {
		this.name = name;
		this.type = type;
		this.path = path;
	}

	@Override
	public String toString() {
		return "ResultConfig [name=" + name + ", type=" + type + ", path=" + path + "]";
	}
}
