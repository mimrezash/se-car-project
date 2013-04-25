package hybrid.car.test;

import static org.junit.Assert.*;
import hybrid.car.system.Breaks;

import org.junit.Test;

public class BreakTest {

	@Test
	public void test() {
		Breaks bk = new Breaks();
		assertEquals(bk.getName(),"Breaks" );
		assertTrue(bk.getUniqueId() == -1);
		assertFalse(bk.getUniqueId() > -1);		
		
		fail("Not yet implemented");
	}

}
