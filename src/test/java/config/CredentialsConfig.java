package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/credentials.properties"
})
public interface CredentialsConfig extends Config {

    @Key("bslogin")
    String bs_login();

    @Key("bspassword")
    String bs_password();

    @Key("bsserver")
    String bs_server();
}
