package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class customer extends user {
    
    public customer(String username,String password)
    {
        super(username,password);
        
    }
    
    
   
   
    public String getName()
    {
    	return this.username;
    }
   
    
    
}