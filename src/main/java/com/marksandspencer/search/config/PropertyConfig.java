package com.marksandspencer.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class PropertyConfig {

	private static final Resource[] LOCAL_PROPERTIES = new ClassPathResource[] {
			new ClassPathResource("/properties/search-assembler-service.properties") };

	private static final Resource[] TEST_PROPERTIES = new ClassPathResource[] {
			new ClassPathResource("/properties/search-assembler-service.properties") };

	private static final Resource[] STAGE_PROPERTIES = new ClassPathResource[] {
			new ClassPathResource("/properties/stage/search-assembler-service.properties") };

	private static final Resource[] PROD_PROPERTIES = new ClassPathResource[] {
			new ClassPathResource("/properties/prod/search-assembler-service.properties") };

	@Profile({ "default", "dev" })
	public static class LocalConfig {
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
			PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
			config.setLocations(LOCAL_PROPERTIES);
			return config;
		}
	}

	@Profile("test")
	public static class TestConfig {
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
			PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
			config.setLocations(TEST_PROPERTIES);
			return config;
		}
	}

	@Profile("stage")
	public static class StageConfig {
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
			PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
			config.setLocations(STAGE_PROPERTIES);
			return config;
		}
	}

	@Profile("prod")
	public static class ProdConfig {
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
			PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
			config.setLocations(PROD_PROPERTIES);
			return config;
		}
	}
}