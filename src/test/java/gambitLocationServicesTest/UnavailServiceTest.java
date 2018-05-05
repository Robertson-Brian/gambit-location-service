/**
 * 
 */
package gambitLocationServicesTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.gambit.entities.Unavailabilities;
import com.revature.gambit.repository.UnavailRepo;
import com.revature.gambit.services.UnavailService;

/**
 * @author Lovick
 *
 */
public class UnavailServiceTest {
	static UnavailRepo unavailRepo;
	static UnavailService unavailService;
	List<Unavailabilities> uniList;
	Unavailabilities uni1;
	Unavailabilities uni2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		unavailRepo = mock(UnavailRepo.class);
		unavailService = spy(new UnavailService(unavailRepo));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		unavailRepo = null;
		unavailService = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		uni1 =  new Unavailabilities(1L, null, null, 1L, "Testing", 1L);
		uni1 =  new Unavailabilities(2L, null, null, 2L, "Testing", 2L);
		uniList = new ArrayList<Unavailabilities>();
		uniList.add(uni1);
		uniList.add(uni2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		uni1 = null;
		uni2 = null;
		uniList = null;
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.UnavailService#findAllUnavailabilities()}.
	 */
	@Test
	public void testFindAllUnavailabilities() {
		when(unavailRepo.findAll()).thenReturn(uniList);
		assertNotNull(unavailService.findAllUnavailabilities());
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.UnavailService#createUnavailabilities(com.revature.gambit.entities.Unavailabilities)}.
	 */
	@Test
	public void testCreateUnavailabilities() {
		when(unavailRepo.saveAndFlush(uni2)).thenReturn(uni2);
		assertSame(uni2,unavailService.createUnavailabilities(uni2));
	}

}
