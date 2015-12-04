package capturing;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

import mockit.Capturing;
import mockit.Expectations;

import org.junit.Assert;
import org.junit.Test;

public class Demo {

	@Test
	public void testWithDifferentBehaviorForFirstNewInstanceAndRemainingNewInstances(
			@Capturing/*(maxInstances=1)*/ final Buffer firstNewBuffer,
			@Capturing final Buffer remainingNewBuffers) {
		new Expectations() {
			{
				firstNewBuffer.position();
				result = 10;
				
				remainingNewBuffers.position();
				result = 20;
			}
		};

		// Code under test creates several buffers...
		ByteBuffer buffer1 = ByteBuffer.allocate(100);
		IntBuffer buffer2 = IntBuffer.wrap(new int[] { 1, 2, 3 });
		CharBuffer buffer3 = CharBuffer.wrap("                ");

		// ... and eventually read their positions, getting 10 for
		// the first buffer created, and 20 for the remaining ones.
		Assert.assertEquals(10, buffer1.position());
		Assert.assertEquals(20, buffer2.position());
		Assert.assertEquals(20, buffer3.position());
	}
}
