package br.com.primeup.cardif.services.faker;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Interface do Serviço que retorna dados fakes
 * 
 * @author PrimeUp
 *
 */
public interface FakerService {

	/**
	 * Método que retorna um valor fake de acordo com o nome do campo, seu tipo,
	 * tamanho e se deve retornar um dado válido
	 * 
	 * @param fieldName
	 * @param fieldType
	 * @param size
	 * @param valid
	 * @return
	 */
	

	/**
	 * Método que processa um determinado valor para verificar se algum dado deve
	 * ser gerado dependendo do seu contéudo
	 * 
	 * @param value   valor que deve ser analisado
	 * @param maxSize tamanho máximo do valor que deve ser retornado
	 * @return
	 */
	String processValue(String value, int maxSize);

	/**
	 * Método que analisa a expressão e retorna o valor calculado
	 * 
	 * @param formula expressão aritmetica a ser realizada
	 * 
	 * @return
	 */
	String processValue(String formula);

	/**
	 * Método que retorna uma data de acordo com a condição e formato
	 * 
	 * @param regraData
	 * @param formatDate
	 * @param dataReferencia
	 * @return dataFormatada
	 */
	String getValueDate(String regraData, SimpleDateFormat formatDate, String dataReferencia);

	/**
	 * Método que retorna uma data de acordo com os parametros e formato
	 * 
	 * @param formatDate
	 * @param dataIni
	 * @param dataFim
	 * @return dataFormatada
	 */
	String getValueDate(SimpleDateFormat formatDate, Date dataIni, Date dataFim);
	
	/**
	 * Método que retorna uma data de acordo com os parametros e formato
	 * 
	 * @param formatDate
	 * @param size
	 * @param valid
	 * @return dataFormatada
	 */
	String getValueDate(SimpleDateFormat formatDate, int size ,boolean valid);
}
