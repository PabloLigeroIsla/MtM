package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate 
{
	private Connection c;
	
	public JDBCUpdate(Connection c)
	{
		this.c = c;
	}
	
	//Update
	public void update(String table, String colChange, String stringChange, int intChange, String colSearch, int pkSearch)
	{
		
		if(stringChange == null)
		{
			try
			{
				String sql = "UPDATE "+table+" SET "+colChange+"=? WHERE "+colSearch+"=?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1,intChange);
				prep.setInt(2, pkSearch);
				prep.executeUpdate();
				
				prep.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
		}else
		{
			try
			{
				String sql = "UPDATE "+table+" SET "+colChange+" LIKE ? WHERE "+colSearch+"=?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1,stringChange);
				prep.setInt(2, pkSearch);
				prep.executeUpdate();
				
				prep.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
	public void updateMachinery(int pkSearch, String stateofMachinery){
		
	try
			{
		String sql = "UPDATE machinery SET stateofMachinery LIKE ? WHERE machinery_ID = ? ";

				PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1, stateofMachinery);
				prep.setInt(2, pkSearch);
				prep.executeUpdate();
				
				prep.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
		}
		
<<<<<<< HEAD


=======
	
>>>>>>> branch 'master' of https://github.com/papsers/MtM.git
	public void updateWarehouse(int filledSpaceUpdated){
		
		Statement st;
		try {
			st = c.createStatement();
			String sql = "UPDATE warehouse SET filledSpace = "+filledSpaceUpdated+" WHERE warehouse_ID=1";
			st.executeUpdate(sql);
			
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
