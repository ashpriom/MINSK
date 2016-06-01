import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Vector;
/**
 * 
 * @author teamG
 *
 */

//this one does not work when there is a same class name (just for this project)

public class CouplingFactor {
	private Vector<File> java_file;
	//private Vector<String> v_functions;
	private int coupling;
	private int n;

	public CouplingFactor() {
		n = 0;
		coupling = 0;
		java_file = new Vector<File>();
	}

	public boolean isJavaFile(String file) {
		return file.matches("^.*\\.java$");
	}

	/*
	 * public boolean isFunction(String line){ return
	 * line.matches("^.*public (static |)(String|boolean|void|double).*(.*).*$"
	 * ); }
	 */

	public boolean isIncludedbyClass(String classname, String line) {
		return line.matches("^.*" + classname + ".*$");
	}

	public void compute() {
		Scanner input = null;
		int i = 0;
		Vector<String> classnames = new Vector<String>();
		for (File file : java_file) {
			try {
				for (File file2 : java_file) {
					classnames = new Vector<String>();
					if (file.equals(file2)) {
						continue;
					}
					String filename = file.getName().replaceFirst("[.][^.]+$", "");
					input = new Scanner(file2);
					while (input.hasNextLine()) {
						String line = input.nextLine();
						if (isIncludedbyClass(filename, line)) {
							boolean isCompare = false;
							for (String classname : classnames) {
								if (!filename.equals(classname)) {
									isCompare = true;
								}
								System.out.println(classname+".java");
								System.out.println(filename+".file");
							}
							if (!isCompare) {
								System.out.println(filename+" ---> "+file2.getName());
								classnames.add(filename);
								++coupling;
								break;
							}
						}
					}
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("the number of actual couplings (c) :: "+coupling);
		System.out.println("number of classes (n):: "+ n);
		double result = coupling/(Math.pow(n, 2)-n);
		
		System.out.println("Coupling Factor (formula c/[(n^2)-n]) :: "+result);
	}

	public boolean listFilesForFolder(final String folder) {
		try {
			Files.walk(Paths.get(folder)).forEach(filePath -> {
				if (Files.isRegularFile(filePath)) {
					if (isJavaFile(filePath.toString())) {
						java_file.add(filePath.toFile());
						++n;
					}
				}
			});
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("it is not a folder");
			return false;
		}
	}

	public static void main(String[] args) {
		CouplingFactor cf = new CouplingFactor();
		Scanner sc = new Scanner(System.in);
		boolean isFolder = false;
		while(!isFolder){
			System.out.println("put folder name to compute coupling factor (CF) ::");
			String path = sc.next();
			isFolder=cf.listFilesForFolder(path);
		}
		cf.compute();
	}
}
