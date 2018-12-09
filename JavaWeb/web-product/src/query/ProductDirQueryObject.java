package query;

import util.StringUtil;

/**
 * 	商品分类的查询对象
 * @author Willing
 *
 */
public class ProductDirQueryObject extends QueryObject {
	private String dirName;
	

	@Override
	protected void customizedQuery() {
		if(StringUtil.hasLength(dirName)) {
			addQuery(" dirName LIKE ? ", dirName);
		}
	}

	
	
	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}
	
	
}
