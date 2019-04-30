package filehandlers;

/**
 * FileIOTest purpose is to test FileIO class.
 * 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-04-26
 */

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class FileIOTest {

	FileIO fio = new FileIO();

	// test_normal method tests if the context of the given file is read.
	@Test
	public void test_normal() {
		int[] fileContext = new int[] { 1, 4, 6, -1, -5 };

		// Using a text file with integers from test/resources.
		Path resourceDirectory = Paths.get("src", "test", "resources", "ValidInputNumbers.txt");
		Assert.assertArrayEquals(fileContext, fio.readFile(resourceDirectory.toString()));// The input is valid integers

	}

	// test_NumberFormatException tests the case where the given file does not only
	// contains integers.
	@Test(expected = NumberFormatException.class)
	public void test_NumberFormatException() {
		int[] fileContext = new int[] { 4, 10, -1, -3 };

		// Using a text file with integers from test/resources.
		Path resourceDirectory = Paths.get("src", "test", "resources", "InvalidContext.txt");
		// The input is not only numbers
		Assert.assertArrayEquals(fileContext, fio.readFile(resourceDirectory.toString()));
	}

}
