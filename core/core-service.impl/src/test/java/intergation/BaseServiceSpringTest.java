package intergation;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * @Title:BaseServiceSpringTest.java
 * @Copyright: Copyright (c) 2016
 * @Description:
 * <br>
 * @Company: lxfintech
 * @Created on 2016-11-13下午9:59:57
 * @author miaoxuehui@lxfintech.com
 */
@ContextConfiguration(locations = { "classpath:spring/applicationContext-service.xml" })
public abstract class BaseServiceSpringTest extends AbstractJUnit4SpringContextTests {

}
