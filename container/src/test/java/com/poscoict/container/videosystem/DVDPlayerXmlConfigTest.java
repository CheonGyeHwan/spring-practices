package com.poscoict.container.videosystem;

import static org.junit.Assert.assertNotNull;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:com/poscoict/container/config/videosystem/DVDPlayerConfig.xml"))
public class DVDPlayerXmlConfigTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	// @Autowired
	// 예외 발생
	// Explicit XML Bean 설정(Avengers)에서는 ID를 자동 부여하지 않는다.
	// 따라서 @Qualifier를 사용할 수 없다.
	private DigitalVideoDisc dvd1;
	
	@Qualifier("IronMan")
	@Autowired
	private DigitalVideoDisc dvd2;
	
	@Ignore
	@Test
	public void testDvd1() {
		assertNotNull(dvd1);
	}
	
	@Test
	public void testDvd2() {
		assertNotNull(dvd2);
	}
	
}
