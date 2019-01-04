package lk.edu.ijse.metromanagement.db;


import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    private Connection connection;

    private static DBConnection dbConnection;

    private DBConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        File file = new File("resources/application.properties");
        FileReader fileReader = new FileReader(file);

        Properties properties = new Properties();
        properties.load(fileReader);

        String ip = properties.getProperty("ip");
        String port = properties.getProperty("port");
        String db = properties.getProperty("db");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        String jdbcUrl = "jdbc:mysql://" + ip + ":" + port + "/" + db;

        connection=DriverManager.getConnection(jdbcUrl, user,password);
    }

    public Connection getConnection(){
        return connection;
    }

    public static DBConnection getInstance() throws Exception{
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}
