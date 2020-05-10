package com.hedgehogs.statistics.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Configuration
@PropertySource("classpath:private.properties")
@ComponentScan("com.hedgehogs.statistics")
public class AppConfig {
}
