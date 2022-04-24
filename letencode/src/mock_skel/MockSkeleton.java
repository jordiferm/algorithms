package mock_skel;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;

interface Receiver {
    void receive(String message);
}

public class MockSkeleton {

    @Test
    public void testMock() {
        Mockery context = new Mockery();
        Receiver receiver = context.mock(Receiver.class);
        context.checking(new Expectations() {{
            oneOf (receiver).receive("hello");
        }});
        receiver.receive("hello");
        context.assertIsSatisfied();
    }

    public static void main(String[] args) {
        JUnitCore.main("Solution");
    }

}
