package com.poscoict.container.config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 
 * <---------- JavaConfig1(DVDConfig) + JavaConfig2(DVDPlayerConfig)
 *    import
 *    
 *    JavaConfig1 + JavaConfig2
 *    
 */

@Import({DVDConfig.class, DVDPlayerConfig.class})
@Configuration
public class VideoSystemConfig {

}
