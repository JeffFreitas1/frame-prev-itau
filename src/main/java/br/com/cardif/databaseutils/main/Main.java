package br.com.cardif.databaseutils.main;

import br.com.cardif.databaseutils.DatabaseName;
import br.com.cardif.databaseutils.jdbc.DatabaseUtils;
import br.com.cardif.databaseutils.jdbc.queries.Queries;

public class Main {

	public static void main(String[] args) throws Exception {		
		bvp();
		//garantias();
		//vida();
	}
	
	private static void bvp() throws Exception {
		String r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_DESEMPREGO_INVOLUNT_SEM_SINISTRO, DatabaseName.BVP);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_DESEMPREGO_INVOLUNT_SEM_SINISTRO, r, null, DatabaseName.BVP);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_DESEMPREGO_INVOLUNT_SEM_SINISTRO, null, "481", DatabaseName.BVP);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_SINISTRO_BVP_DESEMPREGO_INVOL_SEM_SINISTRO, DatabaseName.BVP);
		System.out.println(r);
		
		
		
		/*r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_INCAPAC_FISICA_TOTAL_TEMP_SEM_SINISTRO, DatabaseName.BVP);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_INCAPAC_FISICA_TOTAL_TEMP_SEM_SINISTRO, "1394181733", null, DatabaseName.BVP);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_INCAPAC_FISICA_TOTAL_TEMP_SEM_SINISTRO, null, "317", DatabaseName.BVP);
		System.out.println(r);*/
		
		/*r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_SINISTRO_BVP_INCAPAC_FISICA_TOTAL_TEMP_SEM_SINISTRO, DatabaseName.BVP);
		System.out.println(r);*/
		
		
		
		/*r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_MORTE_SEM_SINISTRO, DatabaseName.BVP);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_MORTE_SEM_SINISTRO, "1394181733", null, DatabaseName.BVP);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_MORTE_SEM_SINISTRO, null, "179", DatabaseName.BVP);
		System.out.println(r);*/
	}
	
	private static void garantias() throws Exception {
		String r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_GARANTIAS_ROUBO_OU_FURTO_QUALIF_SEM_SINISTRO, DatabaseName.GARANTIAS);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_GARANTIAS_ROUBO_OU_FURTO_QUALIF_SEM_SINISTRO, "775968779", null, DatabaseName.GARANTIAS);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_GARANTIAS_ROUBO_OU_FURTO_QUALIF_SEM_SINISTRO, null, "120445", DatabaseName.GARANTIAS);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_SINISTRO_GARANTIAS_ROUBO_OU_FURTO_QUALIF_SEM_SINISTRO, DatabaseName.GARANTIAS);
		System.out.println(r);
	}
	
	private static void vida() throws Exception {
		/*String r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_DESEMPREGO_SEM_SINISTRO, DatabaseName.CARDIF);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_DESEMPREGO_SEM_SINISTRO, "1265573275", null, DatabaseName.CARDIF);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_DESEMPREGO_SEM_SINISTRO, null, "87134", DatabaseName.CARDIF);
		System.out.println(r);*/
		
		/*r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_SINISTRO_VIDA_DESEMPREGO, DatabaseName.CARDIF);
		System.out.println(r);*/
		
		
		
		/*String r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_DESEMP_INVOLUNT_SEM_SINISTRO, DatabaseName.CARDIF);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_DESEMP_INVOLUNT_SEM_SINISTRO, "1226817324", null, DatabaseName.CARDIF);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_DESEMP_INVOLUNT_SEM_SINISTRO, null, "95298", DatabaseName.CARDIF);
		System.out.println(r);*/
		
		
		
		/*String r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_MORTE_SEM_SINISTRO, DatabaseName.CARDIF);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_MORTE_SEM_SINISTRO, "1265464655", null, DatabaseName.CARDIF);
		System.out.println(r);
		
		r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_MORTE_SEM_SINISTRO, null, "95325", DatabaseName.CARDIF);
		System.out.println(r);*/
		
		/*r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_SINISTRO_VIDA_MORTE, DatabaseName.CARDIF);
		System.out.println(r);*/
		
		
		
		/*String r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_MORTE_COM_SINISTRO, DatabaseName.CARDIF);
		System.out.println(r);*/
		
		
		
		/*String r = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_MORTE_PARCELA_AUT_SEM_SINISTRO, DatabaseName.CARDIF);
		System.out.println(r);*/
		
		
		
		/*String [] x = DatabaseUtils.searchOneLineNColumns(Queries.BUSCA_CERTIF_VIDA_DESEMPREGO_DATA_OCORRENCIA_SINISTRO, DatabaseName.CARDIF);
		System.out.println(x [0] + " - " + x [1]);
		
		x = DatabaseUtils.searchOneLineNColumns(Queries.BUSCA_CERTIF_VIDA_MORTE_PARCELA_AUT_SEM_SINISTRO, "1233928875", null, DatabaseName.CARDIF);
		System.out.println(x [0] + " - " + x [1] + " - " + x [2] + " - " + x [3]);
		
		x = DatabaseUtils.searchOneLineNColumns(Queries.BUSCA_CERTIF_VIDA_MORTE_PARCELA_AUT_SEM_SINISTRO, null, "93088", DatabaseName.CARDIF);
		System.out.println(x [0] + " - " + x [1] + " - " + x [2] + " - " + x [3]);*/
	}
	

}
