package operations;

/**
 * ArrayOperrationsTest purpose is to test ArrayOperrations class.
 * 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-04-26
 */

import org.junit.Test;
import filehandlers.FileIO;
import org.junit.Assert;
import static org.mockito.Mockito.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArrayOperrationsTest {

	FileIO nfio = new FileIO(); // Create FileIO object.
	IntegerOperations niop = new IntegerOperations();// Create IntegerOperations object

	// Create ArrayOperrations object using the objects that were created above.
	ArrayOperrations aop = new ArrayOperrations(nfio, niop);

	/**
	 * This is test_reverseArray method which tests if the signs of the integers
	 * inside an array are reversed. It uses reverseSign method for each integer by
	 * mocking IntegerOperations class.
	 */
	@Test
	public void test_reverseArray() {
		IntegerOperations iop = mock(IntegerOperations.class);

		when(iop.reverseSign(1)).thenReturn(-1);
		when(iop.reverseSign(4)).thenReturn(-4);
		when(iop.reverseSign(6)).thenReturn(-6);
		when(iop.reverseSign(-1)).thenReturn(1);
		when(iop.reverseSign(-5)).thenReturn(5);

		// Using a text file with integers from test/resources.
		Path resourceDirectory = Paths.get("src", "test", "resources", "ValidInputNumbers.txt");
		Assert.assertArrayEquals(new int[] { -1, -4, -6, 1, 5 }, aop.reverseArray(resourceDirectory.toString()));
	}

	/**
	 * This is test_findMaxInFile method which tests if findMaxInFile method from
	 * ArrayOperrations class will return the max from the integers stored in the
	 * file given as input. It uses readFile method to read the given file by
	 * mocking FileIO class.
	 */
	@Test
	public void test_findMaxInFile() {
		FileIO fio = mock(FileIO.class);

		int[] filecontext = { 1, 4, 6, -1, 5 };

		// Using a text file with integers from test/resources.
		Path resourceDirectory = Paths.get("src", "test", "resources", "ValidInputNumbers.txt");
		when(fio.readFile(resourceDirectory.toString())).thenReturn(filecontext);
		Assert.assertEquals(6, aop.findMaxInFile(resourceDirectory.toString()));
	}

}
