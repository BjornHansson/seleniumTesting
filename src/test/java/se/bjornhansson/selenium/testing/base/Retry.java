package se.bjornhansson.selenium.testing.base;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Re-run failed JUnit tests immediately
 * 
 * @see <a href="http://stackoverflow.com/questions/8295100/how-to-re-run-failed-junit-tests-immediately">Stackoverflow</a>
 */
public class Retry implements TestRule {
    private int retryCount;

    public Retry(int retryCount) {
        this.retryCount = retryCount;
    }

    public Statement apply(Statement base, Description description) {
        return statement(base, description);
    }

    private Statement statement(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable caughtThrowable = null;

                // Implement retry logic here
                for (int i = 0; i < retryCount; i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable t) {
                        caughtThrowable = t;
                        System.err.println(description.getDisplayName() + ": Run " + (i + 1) + " failed");
                    }
                }
                System.err.println(description.getDisplayName() + ": Giving up after " + retryCount + " failures");
                throw caughtThrowable;
            }
        };
    }
}