  
package IngerGYM;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
public class Application {
	
	private static final Log LOG = LogFactory.getLog(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    public Config config() {

        Config config = new Config();

        JoinConfig joinConfig = config.getNetworkConfig().getJoin();

        joinConfig.getMulticastConfig().setEnabled(true);
        
        //Necesario para la cache de Spring	
        List<String> serversList = new ArrayList<String>();
		
		serversList.add("ingergym1");
		serversList.add("ingergym2");

		joinConfig.getTcpIpConfig().setEnabled(true).setMembers(serversList);
		
		return config;
    }
    
    @Bean
    public CacheManager cacheManager() {
    	LOG.info("Activating cache...");
    	return new ConcurrentMapCacheManager("cache");
    }
}