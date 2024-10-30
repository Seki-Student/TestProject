import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB 
{
	private Connection connect = null;
	private String dbURL;
	
	public DB()
	{
		dbURL = "jdbc:sqlserver://ISEKI-LAPTOP\\\\SEKIDB;"
				+ "database=Northwind;"
				+ "user=sa;"
				+ "password=password1;"
				+ "encrypt=false;"
				+ "trustServerCertificate=true;"
				+ "loginTimeout=30;";
	}
	
	public DB(String connection)
	{
		dbURL = connection;
	}
	
	public String getCustomerCount()
	{
		String count = null;
		
		try
		{
			connect = DriverManager.getConnection(dbURL);
			
			if (connect != null)
			{
				String countQuery = "SELECT COUNT(*) AS count FROM Customers;";
				Statement statement = connect.createStatement();
				ResultSet rs = statement.executeQuery(countQuery);
				
				while (rs.next())
				{
					count = rs.getString("count");
				}
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (connect != null)
				{
					String countQuery = "SELECT COUNT(*) AS Count FROM CUSTOMERS;";
					Statement stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery(countQuery);
					
					while (rs.next())count = rs.getString("count");
					{
						
					}
				}
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				try
				{
					if (connect != null && !connect.isClosed())
					{
						connect.close();
					}
				}
				catch (SQLException ex)
				{
					ex.printStackTrace();
				}
			}
		}
		
		return count;
	}
	
	public String getCompanyNames()
	{
		String result = "";
		
		try
		{
			if (connect != null)
			{
				String companyNameQuery = "SELECT companyname FROM CUSTOMERS;";
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery(companyNameQuery);
				
				while (rs.next())
				{
					result += rs.getString("companyname");
					result += "\n";
				}
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (connect != null && !connect.isClosed())
				{
					connect.close();
				}
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		return result;
	}
}
