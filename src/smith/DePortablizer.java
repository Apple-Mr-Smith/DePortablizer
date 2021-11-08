package smith;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DePortablizer {
	public static void StartInstall(String Name,
			String EXE,
			String Root,
			Boolean isStandalone,
			Boolean doStartMenuShortcuts,
			Boolean doDesktopShortcuts,
			String Path) {

		File dest = new File(Path + "\\" + Name);
		dest.mkdir();
		try {
			copyDirectory(Root, dest.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private static void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation) 
		  throws IOException {
		    Files.walk(Paths.get(sourceDirectoryLocation))
		      .forEach(source -> {
		          Path destination = Paths.get(destinationDirectoryLocation, source.toString()
		            .substring(sourceDirectoryLocation.length()));
		          try {
		              Files.copy(source, destination);
		          } catch (IOException e) {
		              e.printStackTrace();
		          }
		      });
		}
}
