package br.com.cardif.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;

import br.com.cardif.testrules.TestRule;

public class CsvUtils {


	public static void writeDataCsv(List<Map<String, String>> formulario, String nomeArquivo) {
		File file = new File(TestRule.getPathCenarioEvidencia().concat("\\"+nomeArquivo + ".csv"));
		String filepath = TestRule.getPathCenarioEvidencia().concat("\\"+nomeArquivo + ".csv");
		try {
			FileWriter output = new FileWriter(file);
			PrintWriter out = new PrintWriter(new File(filepath), "iso-8859-1");
			
						
			@SuppressWarnings("deprecation")
			CSVWriter write = new CSVWriter(out, ';');
			
			

			// Header column value
			String[] header = new String[formulario.size()];

			for (int i = 0; i < header.length; i++) {

				header[i] = formulario.get(i).get("Campo");

			}
			
			write.writeNext(header);

			
			//Data values
			String[] data = new String[formulario.size()];

			for (int i = 0; i < data.length; i++) {

				data[i] = formulario.get(i).get("Valor");

			}
			write.writeNext(data);
			write.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

}
