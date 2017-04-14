package update;

import java.sql.PreparedStatement;

import tools.DBHelper;

public class Clear {
	
	public static void main(String[] args){
		Clear c = new Clear();
		c.createTable();
	}

	public void clear() {
		DBHelper database = DBHelper.getInstance();
		PreparedStatement statement = null;

		String sql = "DROP TABLE IF EXISTS product";
		try {
			statement = database.conn.prepareStatement(sql);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createTable() {
		DBHelper database = DBHelper.getInstance();
		PreparedStatement statement = null;

		String sql = "CREATE TABLE product"
				+ "(id varchar(255),product varchar(255),typeName varchar(255),parent varchar(255),"
				+ "storage int,store varchar(255),storeLink varchar(255),price varchar(255),"
				+ "imageLink varchar(255),volumn int,description varchar(255),value varchar(255),PRIMARY KEY(id))";
		try {
			statement = database.conn.prepareStatement(sql);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
