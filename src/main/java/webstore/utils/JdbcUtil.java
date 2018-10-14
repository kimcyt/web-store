package webstore.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class JdbcUtil {

	public static DataSource ds = null;
	static {
		try {
			Properties p = new Properties();
			//any classes inside folder classes, use its classLoader, can load 
			//any resources inside the folder
			String path = JdbcUtil.class.getClassLoader()
					.getResource("db.properties").getPath();
			FileInputStream in = new FileInputStream(path);
			p.load(in);
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConn() {
		try {
			return ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn, Statement st, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(st != null) {
			try {
				st.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	
}
