package query;

import util.StringUtil;

public class EmployeeQueryObject extends QueryObject {
	private String keyword;
	private java.util.Date minEntryDate;
	private java.util.Date maxEntryDate;

	@Override
	protected void customizedQuery() {
		if (StringUtil.hasLength(keyword)) {
			super.addQuery("username LIKE ? ", "%" + keyword + "%");
		}
		if (minEntryDate != null) {
			super.addQuery("entryDate >= ?", minEntryDate);
		}
		if (maxEntryDate != null) {
			super.addQuery("entryDate <= ?", maxEntryDate);
		}
	}

	// ====================
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public java.util.Date getMinEntryDate() {
		return minEntryDate;
	}

	public void setMinEntryDate(java.util.Date minEntryDate) {
		this.minEntryDate = minEntryDate;
	}

	public java.util.Date getMaxEntryDate() {
		return maxEntryDate;
	}

	public void setMaxEntryDate(java.util.Date maxEntryDate) {
		this.maxEntryDate = maxEntryDate;
	}

}
