package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${enviroment}.properties")
public interface RegistrationConfig extends Config {
    @DefaultValue("Donald")
    String firstName();
    @DefaultValue("Duck")
    String lastName();
}
