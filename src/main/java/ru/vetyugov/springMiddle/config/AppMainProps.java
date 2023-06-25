package ru.vetyugov.springMiddle.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.Locale;

@Getter
@ConfigurationProperties(prefix = "main")
public class AppMainProps {
    private final Locale locale;

    @ConstructorBinding
    public AppMainProps(Locale locale) {
        this.locale = locale;
    }
}
