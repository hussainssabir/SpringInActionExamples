package concert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class EncoreableTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private Performance performance;

    @Test
    public void testPerformanceEncoreable() {
        Encoreable encoreable = (Encoreable) performance;
        encoreable.performEncore();
        assertEquals("Default encoreable\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void testPerformance() {
        performance.perform();
        assertEquals("Silencing cell phones\n" +
                "Taking seats\n" +
                "Piano Solo\n" +
                "CLAP CLAP CLAP!!!\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }
}
