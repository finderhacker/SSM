package ziji;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Junit4TimeoutTest.class, Junit4ExceptionTest.class, Junit4ParameterTest.class})
public class Junit4SuiteTest {

}
