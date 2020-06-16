package com.example.demo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.google.common.collect.Lists;

/**
 * Open cross-domain access configuration
 */
//@Configuration
public class CorsConfig {

    /**
     * CORS Configuration
     *
     * @return
     */
    private CorsConfiguration buildConfig() {
        //New CORS configuration
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //Set the request source HTTP allowed to access
        corsConfiguration.addAllowedOrigin("*");
        //Set the request source method to allow access
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        //Added new header, need to configure whitelist
        List<String> allowedHeaders = Lists.newArrayList();
        allowedHeaders.add("Content-Type");
        allowedHeaders.add("authorization");
        allowedHeaders.add("x-requested-with");
        corsConfiguration.setAllowedHeaders(allowedHeaders);
        //Return to CORS configuration
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        // New path mapping configuration for cross-domain access
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Paths for cross-domain access
        source.registerCorsConfiguration("/**", buildConfig());
        // Back to cross-domain filtering
        return new CorsFilter(source);
    }
}
