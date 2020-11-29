package src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import src.LoginBean;
import src.DBConnection;
 
public class LoginDao {
 
public String authenticateUser(LoginBean loginBean)
{
    String userName = loginBean.getUserName();
    String password = loginBean.getPassword();
 
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    String userNameDB = "";
    String passwordDB = "";
    String userDB = "";
 
    try
    {
        con = DBConnection.createConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("select username,password,role from users");
 
        while(resultSet.next())
        {
            userNameDB = resultSet.getString("username");
            passwordDB = resultSet.getString("password");
            userDB = resultSet.getString("user_level");
 
            if(userName.equals(userNameDB) && password.equals(passwordDB) && userDB.equals("Level 1"))
            return "Level 1";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && userDB.equals("Level 2"))
            return "Level 2";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && userDB.equals("Level 3"))
            return "Level 3";
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
}
}