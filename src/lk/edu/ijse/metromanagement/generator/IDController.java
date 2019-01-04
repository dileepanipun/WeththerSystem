package lk.edu.ijse.metromanagement.generator;

import lk.edu.ijse.metromanagement.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IDController {
    public static String getLastID(String tableName,String columnName) throws Exception{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        String sql="select "+columnName+" from "+tableName+" order by 1 desc limit 1";
        ResultSet rst = stm.executeQuery(sql);

        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
}
