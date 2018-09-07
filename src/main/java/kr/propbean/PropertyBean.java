package kr.propbean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "commandlinerunner")
public class PropertyBean {

    private String prop1;

    public PropertyBean() {
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    @Override
    public String toString() {
        return "PropertyBean{" +
                "prop1='" + prop1 + '\'' +
                '}';
    }
}
