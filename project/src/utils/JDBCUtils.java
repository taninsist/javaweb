package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接池工具
 * 1.导入jar包
 * 2.定义配置文件，该文件可以放在任意目录下，一般情况放在src目录下
 * */
public class JDBCUtils {
    private static DataSource dataSource;
    //静态代码块
    static {
        //1.创建读取配置文件的对象
        Properties properties=new Properties();
        try {
            //2.导入数据库连接池配置信息文件
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //3.通过工厂创建数据库连接池
            dataSource=DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    //归还链接，释放资源
    public static void close(Connection connection, PreparedStatement psmt) throws SQLException {
        /*if (connection!=null){
            connection.close();
        }

        if (psmt!=null){
            psmt.close();
        }*/

        JDBCUtils.close(null,psmt,connection);
    }

    public static void close(ResultSet rlt,PreparedStatement pstmt,Connection connection) throws SQLException {
        if (rlt!=null){
            rlt.close();
        }

        if (connection!=null){
            connection.close();
        }

        if (pstmt!=null){
            pstmt.close();
        }
    }

}
