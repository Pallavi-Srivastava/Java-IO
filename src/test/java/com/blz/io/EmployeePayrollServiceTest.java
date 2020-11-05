package com.blz.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollServiceTest {
	private static String HOME = System.getProperty("user.home");
	private static String PlayWithNIO = "Play Ground";

	@Test
	public void givenPathCheckedThenConfirm() throws IOException {
		// Check File Exists
		Path homePath = Paths.get(HOME);
		System.out.println(homePath);
		Assert.assertTrue(Files.exists(homePath));

		// Delete File and Check File Exist or Not
		Path playPath = Paths.get(HOME + "/" + PlayWithNIO);
		if (Files.exists(playPath))
			FileUtils.deleteFiles(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));

		// Create Directory
		Files.createDirectories(playPath);
		Assert.assertTrue(Files.exists(playPath));

		// Create File
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
			}
			Assert.assertTrue(Files.exists(tempFile));
		});

		// ListFiles.Dir as well as file with extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);
	}
}
