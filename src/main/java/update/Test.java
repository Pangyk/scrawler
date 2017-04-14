package update;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tools.DBHelper;

public class Test {

	public static void main(String[] args) {
		DBHelper database = DBHelper.getInstance();
		PreparedStatement statement = null;

		String sql = "SELECT * from product limit 10";
		try {
			statement = database.conn.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				System.out.println(set.getString(1) + " " + set.getString(2) + " " + set.getString(3) + " "
						+ set.getString(4) + " " + set.getInt(5) + " " + set.getString(6) + " " + set.getString(7) + " "
						+ set.getString(8) + " " + set.getString(9) + " " + set.getInt(10) + " " + set.getString(11)
						+ " " + set.getString(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
