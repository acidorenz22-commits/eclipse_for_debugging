package snippet;

public class Snippet {
	# Root log level
	logging.level.root=DEBUG
	
	# Spring logs
	#logging.level.org.springframework=DEBUG
	
	# MyBatis logs
	logging.level.org.apache.ibatis=DEBUG
	logging.level.java.sql=DEBUG
	
	mybatis.configuration.log-impl=org.apache.ibatis.logging.log4j2.Log4j2Impl
	
	
	management.endpoints.web.exposure.include=*
}

