package br.com.cardif.databaseutils.main;

import br.com.cardif.databaseutils.DatabaseName;
import br.com.cardif.databaseutils.jdbc.DatabaseUtils;
import br.com.cardif.databaseutils.jdbc.queries.Queries;

public class Main {

	public static void main(String[] args) throws Exception {		
		bvp();
		garantias();
		vida();
	}
	
	private static void bvp() throws Exception {
		String r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_DESEMPREGO_INVOLUNT_SEM_SINISTRO, DatabaseName.BVP);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_INCAPAC_FISICA_TOTAL_TEMP_SEM_SINISTRO, DatabaseName.BVP);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_MORTE_SEM_SINISTRO, DatabaseName.BVP);
		System.out.println(r);
	}
	
	private static void garantias() throws Exception {
		String r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_GARANTIAS_ROUBO_OU_FURTO_QUALIF_SEM_SINISTRO, DatabaseName.GARANTIAS);
		System.out.println(r);
	}
	
	private static void vida() throws Exception {
		String r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_DESEMPREGO_SEM_SINISTRO, DatabaseName.CARDIF);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_SINISTRO_VIDA_DESEMPREGO, DatabaseName.CARDIF);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_DESEMP_INVOLUNT_SEM_SINISTRO, DatabaseName.CARDIF);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_MORTE_SEM_SINISTRO, DatabaseName.CARDIF);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_SINISTRO_VIDA_MORTE, DatabaseName.CARDIF);
		System.out.println(r);
		
		String [] x = DatabaseUtils.searchOneLineTwoColumns(Queries.BUSCA_CERTIF_VIDA_DESEMPREGO_DATA_OCORRENCIA_SINISTRO, DatabaseName.CARDIF);
		System.out.println(x [0] + " - " + x [1]);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_MORTE_COM_SINISTRO, DatabaseName.CARDIF);
		System.out.println(r);
	}
	

}
