package ru.vetyugov.springMiddle.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@Getter
@ConfigurationProperties(prefix = "question")
public class AppQuestionProps {
    private final String bundleFileName;

    private final String regex;

    @ConstructorBinding
    public AppQuestionProps(String bundleFileName, String regex) {
        this.bundleFileName = bundleFileName;
        this.regex = regex;
    }
}
