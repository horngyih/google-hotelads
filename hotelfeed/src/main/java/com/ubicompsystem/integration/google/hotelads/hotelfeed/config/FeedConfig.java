package com.ubicompsystem.integration.google.hotelads.hotelfeed.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.ubicompsystem.integration.google.hotelads.hotelfeed")
public class FeedConfig {}
