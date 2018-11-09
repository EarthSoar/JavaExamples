需求:查询所有货品信息
SELECT * FROM product
需求:查询所有货品的id,productName,salePrice
SELECT id,productName,salePrice FROM product
需求:查询所有货品的id，名称和批发价(批发价=卖价*折扣)
SELECT id,productName,salePrice * cutoff AS 批发价 FROM product 
需求:查询所有货品的id，名称，和各进50个的成本价(成本=costPirce)
SELECT id,productName,costPrice * 50 FROM product
需求:查询所有货品的id，名称，各进50个，并且每个运费1元的成本
SELECT id,productName,(costPrice+1)*50 FROM product
需求:查询所有货品的id，名称，各进50个，并且每个运费1元的成本(使用别名)
SELECT id,productName,(costPrice+1)*50 AS 成本 FROM product
需求:查询商品的名字和零售价。格式xxx商品的零售价为xxx.CONCAT函数来连接字符串
SELECT CONCAT(productName,'的零售价为',salePrice) FROM product
================================
需求: 查询货品零售价为119的所有货品信息.
SELECT * FROM product
WHERE salePrice = 119 
需求: 查询货品名为罗技G9X的所有货品信息.
SELECT * FROM product 
WHERE productName = '罗技G9X'
需求: 查询货品名 不为 罗技G9X的所有货品信息.
SELECT * FROM product 
WHERE productName!= '罗技G9X'
需求: 查询分类编号不等于2的货品信息
SELECT * FROM product 
WHERE dir_id != 2
需求: 查询货品名称,零售价小于等于200的货品
SELECT productName FROM product 
WHERE salePrice <= 200 
需求: 查询id，货品名称，批发价大于350的货品
SELECT id,productName,costPrice FROM product 
WHERE costPrice > 350
需求: 选择id，货品名称，批发价在300-400之间的货品
SELECT * FROM product 
WHERE costPrice BETWEEN 300 AND 400
需求: 选择id，货品名称，分类编号为2,4的所有货品
SELECT id,productName,dir_id FROM product
WHERE dir_id IN (2,4)
需求: 选择id，货品名词，分类编号不为2的所有商品
SELECT id,productName,dir_id FROM product
WHERE dir_id != 2
需求: 选择id，货品名称，分类编号的货品零售价大于等于250或者是成本大于等于200
SELECT id,productName,costPrice,salePrice FROM product
WHERE salePrice >= 250 OR costPrice >= 200
需求: 选择id，货品名称，批发价在300-400之间的货品
SELECT id,productName,costPrice,salePrice FROM product
WHERE  costPrice BETWEEN 300 AND 400
需求: 选择id，货品名称，批发价不在300-400之间的货品
SELECT id,productName,costPrice,salePrice FROM product
WHERE costPrice NOT BETWEEN 300 AND 400
需求:选择id，货品名称，分类编号为2,4的所有货品
SELECT id,productName,dir_id FROM product
WHERE dir_id IN (2,4)
需求:选择id，货品名称，分类编号不为2,4的所有货品
SELECT id,productName,dir_id FROM product
WHERE dir_id NOT IN (2,4)
需求: 查询id，货品名称，货品名称匹配'%罗技M9_'
SELECT id,productName FROM product
WHERE productName LIKE '%罗技M9%'
需求: 查询id，货品名称，分类编号,零售价大于等于200并且货品名称匹配'%罗技M1__'
SELECT id,productName dir_id FROM product
WHERE productName LIKE '%罗技M1_' AND salePrice >= 200
SELECT * FROM product
需求:选择id，货品名称，分类编号,零售价并且按零售价降序排序
SELECT id,productName,dir_id ,salePrice FROM product
ORDER BY salePrice DESC
需求: 选择id，货品名称，分类编号,零售价先按分类编号排序,再按零售价排序
SELECT id,productName,dir_id ,salePrice FROM product
ORDER BY dir_id DESC,salePrice DESC
需求:查询M系列并按照批发价排序(加上别名)
SELECT productName M系列,salePrice 价格 FROM product 
WHERE productName LIKE '罗技M%'
ORDER BY salePrice DESC
需求:查询分类为2并按照批发价排序(加上别名)
SELECT productName 分类为2,costPrice 批发价格 FROM product 
WHERE dir_id = 2
ORDER BY costPrice DESC
=============================
需求:查询所有商品平均零售价
SELECT AVG(salePrice) 商品平均零售价
FROM product 
需求:查询商品总记录数(注意在Java中必须使用long接收)
SELECT	COUNT( DISTINCT id)
FROM product  
需求:查询分类为2的商品总数
SELECT	COUNT(  id)
FROM product  
WHERE dir_id = 2
需求:查询商品的最小零售价，最高零售价，以及所有商品零售价总和
SELECT	MIN(salePrice),MAX(salePrice),SUM(salePrice)
FROM product  
====================================
需求:查询所有的货品信息+对应的货品分类信息
SELECT	*
FROM product p,productdir pd
WHERE p.dir_id = pd.id  
需求:查询所有商品的名称和分类名称:
SELECT	productName,dirName
FROM product p,productdir pd
WHERE p.dir_id = pd.id  
需求: 查询货品id，货品名称，货品所属分类名称
SELECT	p.id,productName,dirName
FROM product p,productdir pd
WHERE p.dir_id = pd.id  
需求: 查询零售价大于200的无线鼠标
SELECT	productName,dirName
FROM product,productdir
WHERE productdir.dirName = '无限鼠标' AND product.salePrice > 200
需求: 查询零售价大于200的无线鼠标(使用表的别名)
SELECT	productName,dirName
FROM product p,productdir pd
WHERE pd.dirName = '无限鼠标' AND salePrice > 200
需求: 查询每个货品对应的分类以及对应的库存
SELECT	p.productName,pd.dirName,ps.storeNum
FROM product p,productdir pd,productstock ps
WHERE p.dir_id = p.id AND p.id = ps.product_id
需求: 如果库存货品都销售完成,按照利润从高到低查询货品名称,零售价,货品分类（三张表）.
SELECT	p.productName,p.salePrice,pd.dirName
FROM product p,productdir pd,productstock ps
WHERE p.dir_id = p.id AND p.id = ps.product_id
ORDER BY  (salePrice - costPrice) DESC
==================================
插入完整数据记录
INSERT INTO productdir VALUES (20,'玩具鼠标',1);
插入数据记录一部分
INSERT INTO productdir (dirName,parent_id) VALUES('儿童鼠标',1)
插入多条数据记录（MySQL特有
INSERT INTO productdir (dirName,parent_id) VALUES('办公鼠标1',1),('办公鼠标2',1),('办公鼠标2',1)
需求:将零售价大于300的货品零售价上调0.2倍
UPDATE product SET salePrice = salePrice*1.2 WHERE salePrice > 300 
需求:插入查询结果(测试)
INSERT INTO productdir (dirName) SELECT dirName FROM productdir
需求:将零售价大于300的有线鼠标的货品零售价上调0.1倍
SELECT * FROM product,productdir WHERE product.salePrice >= 300 AND productdir.dirName = '有线鼠标'
UPDATE product,productdir SET salePrice = salePrice*1.1 WHERE product.dir_id = productdir.id AND dirName = '有线鼠标'
删除玩具鼠标
DELETE FROM productdir WHERE id = 20