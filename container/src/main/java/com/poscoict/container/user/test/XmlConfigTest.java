package com.poscoict.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import com.poscoict.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {
//		testBeanFactory01();
		testBeanFactory02();
	}
	
	// XML Auto Configuration(Annotation Scanning)
	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscoict/container/config/user/applicationContext01.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean ID가 자동으로 설정됨
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
	
	// XML Bean Configuration(Explicit Configuration)
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscoict/container/config/user/applicationContext02.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean ID가 자동으로 설정되지 않음
		// 명시적으로 설정해야 한다
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}

}
