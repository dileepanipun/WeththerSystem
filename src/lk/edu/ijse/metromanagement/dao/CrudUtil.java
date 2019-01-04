package lk.edu.ijse.metromanagement.dao;

import lk.edu.ijse.metromanagement.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CrudUtil {

    private static int questionMark(String sql) {
        int count = 0;
        for (int i = 0; i < sql.length(); i++) {
            if (sql.charAt(i) == '?')
                count++;
        }
        return count;
    }

    private static PreparedStatement getPreparedStatement(String sql, Object... parems) throws Exception{

        if(questionMark(sql) != parems.length){
            throw new RuntimeException(("Parameters Count is Mismacthed"));
        }

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement ptsm = connection.prepareStatement(sql);

        for (int i = 0; i < parems.length; i++){
            ptsm.setObject(i+1, parems[i]);
        }

        return ptsm;
    }

    public static ResultSet executeQuery(String sql, Object... params) throws Exception {
        return getPreparedStatement(sql, params).executeQuery();
    }

    public static int executeUpdate(String sql, Object... params) throws Exception {
        return getPreparedStatement(sql, params).executeUpdate();
    }

}
