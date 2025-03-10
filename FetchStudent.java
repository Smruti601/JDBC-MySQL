import java.sql.*;
public class FetchStudent {
    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mysql://localhost : 3306 /spark";
        String username = "root";
        String password = "root";

        String query = "select * from students ;";

        try{
           // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("ID  |   NAME    |   AGE |   COURSE  ");
            System.out.println("-------------------------------------");
            while(rs.next())
            {
                System.out.println( rs.getInt("id") + "       " +
                                    rs.getString("name") + "        " +
                                    rs.getInt("age") + "       " +
                                    rs.getString("course") + "      "
                                    );
            }

        }
        catch (Exception e)
        {
           // e.printStackTrace();
        }
    }
}
