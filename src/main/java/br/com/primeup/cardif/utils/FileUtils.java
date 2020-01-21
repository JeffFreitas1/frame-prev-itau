package br.com.primeup.cardif.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.primeup.cardif.testrules.TestRule;


public class FileUtils {
	
	public FileUtils() {}
	
	public static boolean deleteTempFolder(String path) {
		try {
			File folder = new File(path);
			if (folder.isDirectory()) {
				File[] files = folder.listFiles();
				for (File toDelete : files) {
					toDelete.delete();
				}
			}
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}
	
	public static Path writeTemplate(byte[] template) throws IOException {
		
		String pathTemplate="C:\\TEMP\\Templates";
		deleteTempFolder(pathTemplate);
		File file= new File(pathTemplate+"\\Template"+System.currentTimeMillis()+".xslm");
		FileOutputStream in = new FileOutputStream(file) ;
		in.write(template);
		in.close();
		return file.toPath();
	}
	
	public static Path writeFeature(byte[] feature)throws IOException {
		
		String pathFeature="C:\\TEMP\\Features";
		deleteTempFolder(pathFeature);
		File file= new File(pathFeature+"\\BDD"+System.currentTimeMillis()+".feature");
		FileOutputStream in = new FileOutputStream(file) ;
		in.write(feature);
		in.close();
		return file.toPath();
	}
	
	public static byte[] writeFeature(String feature)throws IOException {
		
		String pathFeature="C:\\TEMP\\Features";
		deleteTempFolder(pathFeature);
		File file= new File(pathFeature+"\\BDD"+System.currentTimeMillis()+".feature");
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		fw.write(feature);
		fw.close();
		Path path = Paths.get(file.getAbsolutePath());
		
		return Files.readAllBytes(path);
	}
	
	public static Path writePrt(byte[] prt)throws IOException {
		String pathPrtFiles="C:\\TEMP\\PrtFiles";
		deleteTempFolder(pathPrtFiles);
		File file= new File(pathPrtFiles+"\\PRT"+System.currentTimeMillis()+".PRT");
		FileOutputStream in = new FileOutputStream(file);
		in.write(prt);
		in.close();
		return file.toPath();
	}
	
	public static Path writeFileTest(String nomeArquivo,byte[] fileByte, String type)throws IOException {
		File file= new File(TestRule.getPathCenarioEvidencia()+"\\File"+nomeArquivo+"."+type);
		FileOutputStream in = new FileOutputStream(file);
		in.write(fileByte);
		in.close();
		return file.toPath();
	}
	
	public static Path writeFile(String path,String nomeArquivo,byte[] fileByte, String type)throws IOException {
		File file= new File(path+"\\File"+nomeArquivo+"."+type);
		FileOutputStream in = new FileOutputStream(file);
		in.write(fileByte);
		in.close();
		return file.toPath();
	}
}
