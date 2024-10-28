
package atm.simulator;
import java.sql.*;

public class Con {
    Connection c;
    Statement s;
    public Con()
    {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///atmsimulator","root","@AnuJ#24");
            s = c.createStatement();
            
        } catch (Exception e) {
        }
    }
    
}
