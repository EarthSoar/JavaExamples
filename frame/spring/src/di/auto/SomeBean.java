package di.auto;

public class SomeBean {
	private OtherBean other;

	@Override
	public String toString() {
		return "SomeBean [other=" + other + "]";
	}

	public void setOther(OtherBean other) {
		this.other = other;
	}
}
