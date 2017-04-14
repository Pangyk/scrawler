package update;

import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.UUID;

import parse.Product;
import tools.DBHelper;

public class Update {

	public void update(Iterator<Product> productList) {
		DBHelper database = DBHelper.getInstance();
		PreparedStatement statement = null;

		String sql = "INSERT INTO product"
				+ "(id,product,typeName,parent,storage,store,storeLink,price,imageLink,volumn,description,value)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			statement = database.conn.prepareStatement(sql);
			String pid = null;
			while (productList.hasNext()) {
				Product product = productList.next();
				String id = UUID.randomUUID().toString();
				statement.setString(1, id);
				statement.setString(2, product.getProduct());
				statement.setString(3, product.getTypeName());

				statement.setString(4, pid);
				if (product.getIsParent() == 1) {
					pid = id;
				}
				
				statement.setInt(5, product.getStorage());
				statement.setString(6, product.getStore());
				statement.setString(7, product.getStoreLink());
				statement.setString(8, product.getPrice());
				statement.setString(9, product.getImageLink());
				statement.setInt(10, product.getVolumn());
				statement.setString(11, product.getDescription());
				statement.setString(12, product.getValue());
				statement.addBatch();
				System.out.println(id+" "+product.getStore());
			}
			statement.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
