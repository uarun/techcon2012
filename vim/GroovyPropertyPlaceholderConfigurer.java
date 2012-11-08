package com.liquidnet.commons.spring.config;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

/**
 * GroovyPropertyPlaceholderConfigurer - a PropertyPlaceholderConfigurer implementation that
 * supports reading configuration (properties) from Groovy files.
 *
 * Example usage:
 *
 * <pre>
 * &lt;bean id="config" class="groovy.util.ConfigObject"/&gt;
 *
 * &lt;bean class="com.example.GroovyPropertyPlaceholderConfigurer">
 *     &lt;property name="environment" value="#{systemProperties['app.env']}" />
 *     &lt;property name="defaultEnvironment" value="dev" />
 *     &lt;property name="config" ref="config"/>
 *     &lt;property name="locations">
 *         &lt;list>
 *             &lt;value>file:conf/testconfig.groovy</value>
 *             &lt;value>file:conf/test.properties</value>
 *         &lt;/list>
 *     &lt;/property>
 * &lt;/bean>
 *
 * &lt;!-- Optional bean to make the parsed config available to other beans -->
 * &lt;bean id="config" class="groovy.util.ConfigObject"/>
 * </pre>
 *
 * <ul>
 * <li><code>envPropertyName</code> - The name of the system property that would contain the environment name</li>
 * <li><code>config</code> - A reference to a <code>ConfigObject</bean>. The configurer saves the parsed configuration
 * into this object. This enables other beans in the context to access the configuration object using DI.</li>
 * <li><code>locations</code> - list of property file locations. It can contain a combination of .groovy and .properties files.
 * </ul>
 *
 * The properties <code>envPropertyName</code> and <code>config</code> are optional. The <code>locations</code>
 * property should be a list and can contain a combination of .groovy and .properties files.
 *
 * Note: The .properties file should be groovy style properties not regular java property files for e.g. string
 * values should be in double quotes etc.
 * <p>
 *
 * @author Arun Udayashankar
 * @version 1.0.0
 *
 */
public class GroovyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private static final Logger log = LoggerFactory.getLogger(GroovyPropertyPlaceholderConfigurer.class);

    private String environment;
    private String defaultEnvironment;
    private Resource[] locations;
    private ConfigObject config;

    @Override
    protected void loadProperties(Properties props) throws IOException {
        if (config == null) { config = new ConfigObject(); }

        ConfigSlurper slurper;
        String env = getEnvironment();
        if (env != null) { slurper = new ConfigSlurper(env); }
        else             { slurper = new ConfigSlurper();    }

        //... TODO: Optimize this
        for (Resource loc : locations) {
            config.merge(slurper.parse(loc.getURL()));
        }
        props.putAll(config.toProperties());
    }

    public Resource[] getLocations() {
        return locations;
    }

    //... TODO: Test passing in various Resource types
    public void setLocations(Resource[] locations) {
        this.locations = locations;
    }

    public ConfigObject getConfig() {
        return config;
    }

    public void setConfig(ConfigObject config) {
        this.config = config;
    }

    public String getEnvironment() {
        if (environment == null || environment.trim().length() == 0) {
            return defaultEnvironment;
        }
        else {
            return environment;
        }
    }

    //... TODO: Do we really need a setter for environment
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getDefaultEnvironment() {
        return defaultEnvironment;
    }

    public void setDefaultEnvironment(String defaultEnvironment) {
        this.defaultEnvironment = defaultEnvironment;
    }
}

