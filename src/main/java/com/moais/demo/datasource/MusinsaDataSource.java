package com.moais.demo.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(value="com.musinsa.demo.mapper")
public class MusinsaDataSource {
	
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.musinsa")
	public DataSource dataSource() throws Throwable {
		DataSourceBuilder<?> builder = DataSourceBuilder.create();
		DataSource dataSource = builder.build();
		return dataSource;
	}
	
	@Primary
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(
				@Autowired DataSource dataSource,
				ApplicationContext context
				) throws Throwable {		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(context.getResources("classpath:mapper/musinsa/*.xml"));
		return factoryBean.getObject();
	}
	
	@Primary
	@Bean
	public SqlSessionTemplate sqlSession(
				@Autowired SqlSessionFactory sqlSessionFactory
			) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Primary
	@Bean
	public DataSourceTransactionManager transactionManager(
				@Autowired DataSource dataSource
			) {
		return new DataSourceTransactionManager(dataSource);
	}
}
