package ru.vetyugov.springMiddle.config;

import lombok.Getter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({AppQuestionProps.class, AppMainProps.class})
@Getter
public class AppProps {
}
