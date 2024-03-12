package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/${environment}.properties"})
public interface RegistrationConfig extends Config {
    @DefaultValue("Donald")
    String firstName();
    @DefaultValue("Duck")
    String lastName();
}
