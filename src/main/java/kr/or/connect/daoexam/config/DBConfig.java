package kr.or.connect.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.*;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.*;

@Configuration
@EnableTransactionManagement
public class DBConfig {
//	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//	private String user = "spring";
//	private String password = "java";
	
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	   
	private String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";

    private String user = "connectuser";
    
    private String password = "connect123!@#";
	
	// DB연결에 사용하는데 사용하는 DataSource는 여러가지 종류가 있지만 그 중에 많이 사용하는 BasicDataSource가 있다. 
	// BasicDataSource 를 이용할 때 기본적으로 4개의 속성들을 setter메소드를 통해 setting 해 주어야 하다.
    @Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
	}
}
