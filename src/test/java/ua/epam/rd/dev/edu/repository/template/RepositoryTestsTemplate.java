package ua.epam.rd.dev.edu.repository.template;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/appContext.xml" })
@TransactionConfiguration(defaultRollback = true)
@FixMethodOrder(MethodSorters.JVM)
public class RepositoryTestsTemplate extends
		AbstractTransactionalJUnit4SpringContextTests {

}