package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/driver.properties")
public interface
DriverConfig extends Config {
    @Key("browser.name")
    @DefaultValue("mozilla")
    String browserName();
    @Key("browser.version")
    String browserVersion();
    @Key("browser.size")
    String browserSize();
    @Key("browser.remote.url")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String browserRemoteURL();
}
