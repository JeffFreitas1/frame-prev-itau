package br.com.cardif.databaseutils.jdbc.queries;

public class Queries {
	

	// *** Início das consultas da base VIDA. ***
	public static final String BUSCA_CERTIF_VIDA_DESEMPREGO_SEM_SINISTRO =
		" select top 1 pc.policy_no " +
		" from policy_certificate pc (nolock) " +
		" inner join master_policy mp (nolock) on mp.mp_no = pc.mp_no and mp.mp_endors_no = pc.mp_endors_no " +
		" inner join partner p (nolock) on p.partner_id = mp.partner_id " +
		" inner join letter l (nolock) on l.partner_id = p.partner_id " +
		" left join claim c (nolock) on c.policy_no = pc.policy_no " +
		" inner join pc_prod_rsk_covrge_plans pcx (nolock) on pcx.policy_no = pc.policy_no " +
		" and pcx.polcrt_endors_no = pc.polcrt_endors_no " +
		" and pcx.risk_id = 8 " +
		" where c.policy_no is null " +
		" and pc.polcrt_ins_dtm > '20170101' " +
		" and pc.polst_id = 1 " +
		" and getdate() between pc.polcrt_eff_dtm and pc.polcrt_exp_dtm " +
		" and pc.polcrt_del_fg = 'N' " +
		" and mp.mp_del_fg = 'N' " +
		" and pcx.pcprcpln_del_fg = 'N' " +
		" and mp.mp_no not in ( " +
		" 	select mp_no " +
		" 	from present_value_calculator (nolock) " +
		" 	where del_fg = 'N' " +
		" ) " +
		" and l.letter_del_fg = 'N' and l.letter_name like '%documento%' ";
	
	public static final String BUSCA_SINISTRO_VIDA_DESEMPREGO =
		" select top 1 c.claim_no " +
		" from claim c " +
		" inner join policy_certificate pc (nolock) on pc.policy_no = c.policy_no and pc.polcrt_endors_no = c.polcrt_endors_no " +
		" inner join master_policy mp (nolock) on mp.mp_no = pc.mp_no and mp.mp_endors_no = pc.mp_endors_no " +
		" where c.risk_id = 8 " +
		" and c.clmst_id = 1 " +
		" and mp.mp_no not in ( " +
		" 	select mp_no " +
		" 	from present_value_calculator (nolock) " +
		" 	where del_fg = 'N' " +
		" ) " +
		" order by c.claim_no desc ";
	
	public static final String BUSCA_CERTIF_VIDA_DESEMP_INVOLUNT_SEM_SINISTRO =
		" select top 1 pc.policy_no " +
		" from policy_certificate pc (nolock) " +
		" inner join master_policy mp (nolock) on mp.mp_no = pc.mp_no and mp.mp_endors_no = pc.mp_endors_no " +
		" left join claim c (nolock) on c.policy_no = pc.policy_no " +
		" inner join pc_prod_rsk_covrge_plans pcx (nolock) on pcx.policy_no = pc.policy_no and pcx.polcrt_endors_no = pc.polcrt_endors_no and pcx.risk_id = 33 " +
		" where c.policy_no is null " +
		" and pc.polcrt_ins_dtm > '20180101' " +
		" and pc.polst_id = 1 " +
		" and getdate() between pc.polcrt_eff_dtm and pc.polcrt_exp_dtm " +
		" and pc.polcrt_del_fg = 'N' " +
		" and mp.mp_del_fg = 'N' " +
		" and pcx.pcprcpln_del_fg = 'N' ";
	
	public static final String BUSCA_CERTIF_VIDA_MORTE_SEM_SINISTRO =
		" select top 1 pc.policy_no " +
		" from policy_certificate pc (nolock) " +
		" inner join master_policy mp (nolock) " +
		" on mp.mp_no = pc.mp_no and mp.mp_endors_no = pc.mp_endors_no " +
		" inner join mp_claim_rules mcr (nolock) " +
		" on mcr.mp_no = mp.mp_no and mcr.mp_endors_no = mp.mp_endors_no and mcr.risk_id = 1 " +
		" and mcr.clmrls_payment_base = 2 " +
		" inner join partner p (nolock) " +
		" on p.partner_id = mp.partner_id " +
		" inner join letter l (nolock) " +
		" on l.partner_id = p.partner_id " +
		" left join claim c (nolock) " +
		" on c.policy_no = pc.policy_no " +
		" inner join pc_prod_rsk_covrge_plans pcx (nolock) " +
		" on pcx.policy_no = pc.policy_no and pcx.polcrt_endors_no = pc.polcrt_endors_no " +
		" and pcx.risk_id = 1 " +
		" where c.policy_no is null " +
		" and pc.polcrt_firstpay_due_dtm is null " +
		" and pc.polcrt_ins_dtm > '20170101' " +
		" and pc.polst_id = 1 " +
		" and getdate() between pc.polcrt_eff_dtm and pc.polcrt_exp_dtm " +
		" and pc.polcrt_del_fg = 'N' " +
		" and mp.mp_del_fg = 'N' " +
		" and pcx.pcprcpln_del_fg = 'N' " +
		" and l.letter_del_fg = 'N' " +
		" and l.letter_name like '%documento%' ";
	
	public static final String BUSCA_CERTIF_VIDA_MORTE_PARCELA_AUT_SEM_SINISTRO =
		" select top 1 pc.policy_no, convert(varchar, pc.polcrt_firstpay_due_dtm, 103) firstpay, pc.polcrt_stated_period_vl, pc.polcrt_instmnt_vl " +
		" from policy_certificate pc (nolock) " +
		" inner join master_policy mp (nolock) " +
		" on mp.mp_no = pc.mp_no and mp.mp_endors_no = pc.mp_endors_no " +
		" inner join mp_claim_rules mcr (nolock) " +
		" on mcr.mp_no = mp.mp_no and mcr.mp_endors_no = mp.mp_endors_no and mcr.risk_id = 1 " +
		" and mcr.clmrls_payment_base = 2 " +
		" inner join partner p (nolock) " +
		" on p.partner_id = mp.partner_id " +
		" inner join letter l (nolock) " +
		" on l.partner_id = p.partner_id " +
		" left join claim c (nolock) " +
		" on c.policy_no = pc.policy_no " +
		" inner join pc_prod_rsk_covrge_plans pcx (nolock) " +
		" on pcx.policy_no = pc.policy_no and pcx.polcrt_endors_no = pc.polcrt_endors_no " +
		" and pcx.risk_id = 1 " +
		" where c.policy_no is null " +
		" and pc.polcrt_firstpay_due_dtm is not null and pc.polcrt_instmnt_vl is not null " +
		" and pc.polcrt_stated_period_vl is not null " +
		" and mcr.clmrls_shortage = 0 "+
		" and pc.polcrt_ins_dtm > '20170101' " +
		" and pc.polst_id = 1 " +
		" and getdate() between pc.polcrt_eff_dtm and pc.polcrt_exp_dtm " +
		" and pc.polcrt_del_fg = 'N' " +
		" and mp.mp_del_fg = 'N' " +
		" and pcx.pcprcpln_del_fg = 'N' " +
		" and l.letter_del_fg = 'N' " +
		" and l.letter_name like '%documento%' ";
	
	public static final String BUSCA_SINISTRO_VIDA_MORTE =
		" select top 1 c.claim_no " +
		" from claim c " +
		" inner join policy_certificate pc on pc.policy_no = c.policy_no and pc.polcrt_endors_no = c.polcrt_endors_no " +
		" inner join master_policy mp on mp.mp_no = pc.mp_no and mp.mp_endors_no = pc.mp_endors_no " +
		" where c.risk_id = 1 " +
		" and c.clmst_id = 1 " +
		" order by c.claim_no desc ";
	
	public static final String BUSCA_CERTIF_VIDA_DESEMPREGO_DATA_OCORRENCIA_SINISTRO =
		" select top 1 c.policy_no, convert(varchar, c.clm_occurrency_dtm, 103) " +
		" from claim c (nolock) " +
		" inner join risk r (nolock) on r.risk_id = c.risk_id " +
		" where c.risk_id = 8 " +
		" and c.clmst_id <> 8 " +
		" and c.clm_del_fg = 'N' " +
		" order by c.claim_no desc ";
	
	public static final String BUSCA_CERTIF_VIDA_MORTE_COM_SINISTRO = 
		" select top 1 c.policy_no " +
		" from claim c " +
		" inner join risk r on r.risk_id = c.risk_id " +
		" where c.risk_id = 1 " +
		" and c.clmst_id <> 8 " +
		" and r.rsk_cancel_pc = 'S' " +
		" and c.clm_del_fg = 'N' " +
		" order by c.claim_no desc ";
	// *** Fim das consultas da base VIDA. ***
	
	
	
	// *** Início das consultas da base BVP. ***
	public static final String BUSCA_CERTIF_BVP_DESEMPREGO_INVOLUNT_SEM_SINISTRO =
		" select top 1 pc.policy_no " +
		" from policy_certificate pc (nolock) " +
		" inner join master_policy mp (nolock) on mp.mp_no = pc.mp_no and mp.mp_endors_no = pc.mp_endors_no " +
		" inner join partner p (nolock) on p.partner_id = mp.partner_id " +
		" inner join letter l (nolock) on l.partner_id = p.partner_id " +
		" left join claim c (nolock) on c.policy_no = pc.policy_no " +
		" inner join pc_prod_rsk_covrge_plans pcx (nolock) on pcx.policy_no = pc.policy_no and pcx.polcrt_endors_no = pc.polcrt_endors_no and pcx.risk_id = 8 " +
		" where c.policy_no is null " +
		" and pc.polcrt_instmnt_vl is null " +
		" and pc.polst_id = 1 " +
		" and pc.polcrt_ins_dtm > '20180101' " +
		" and getdate() between pc.polcrt_eff_dtm and pc.polcrt_exp_dtm " +
		" and pc.polcrt_del_fg = 'N' " +
		" and mp.mp_del_fg = 'N' " +
		" and pcx.pcprcpln_del_fg = 'N' " +
		" and l.letter_del_fg = 'N' and l.letter_name like '%documento%' ";
	
	public static final String BUSCA_CERTIF_BVP_INCAPAC_FISICA_TOTAL_TEMP_SEM_SINISTRO =
		" select top 1 pc.policy_no " +
		" from policy_certificate pc (nolock) " +
		" inner join master_policy mp (nolock) on mp.mp_no = pc.mp_no and mp.mp_endors_no = pc.mp_endors_no " +
		" left join claim c (nolock) on c.policy_no = pc.policy_no " +
		" inner join pc_prod_rsk_covrge_plans pcx (nolock) on pcx.policy_no = pc.policy_no and pcx.polcrt_endors_no = pc.polcrt_endors_no and pcx.risk_id = 9 " +
		" where c.policy_no is null " +
		" and pc.polst_id = 1 " +
		" and pc.polcrt_ins_dtm > '20170101' " +
		" and getdate() between pc.polcrt_eff_dtm and pc.polcrt_exp_dtm " +
		" and pc.polcrt_del_fg = 'N' " +
		" and mp.mp_del_fg = 'N' " +
		" and pcx.pcprcpln_del_fg = 'N' ";
	
	public static final String BUSCA_CERTIF_BVP_MORTE_SEM_SINISTRO =
		" select top 1 pc.policy_no " +
		" from policy_certificate pc (nolock) " +
		" inner join master_policy mp (nolock) on mp.mp_no = pc.mp_no and mp.mp_endors_no = pc.mp_endors_no " +
		" left join claim c (nolock) on c.policy_no = pc.policy_no " +
		" inner join pc_prod_rsk_covrge_plans pcx (nolock) on pcx.policy_no = pc.policy_no and pcx.polcrt_endors_no = pc.polcrt_endors_no and pcx.risk_id = 1 " +
		" where c.policy_no is null  " +
		" and pc.polst_id = 1 " +
		" and pc.polcrt_ins_dtm > '20170101' " +
		" and getdate() between pc.polcrt_eff_dtm and pc.polcrt_exp_dtm " +
		" and pc.polcrt_del_fg = 'N' " +
		" and mp.mp_del_fg = 'N' " +
		" and pcx.pcprcpln_del_fg = 'N' ";
	
	public static final String BUSCA_SINISTRO_BVP_INCAPAC_FISICA_TOTAL_TEMP_SEM_SINISTRO =
		"select top 1 claim_no " +
		"from claim (nolock) " +
		"where risk_id = 9 " +
		"and clmst_id = 1 " +
		"order by claim_no desc ";
	
	public static final String BUSCA_SINISTRO_BVP_DESEMPREGO_INVOL_SEM_SINISTRO =
		"select top 1 claim_no " +
		"from claim (nolock) " +
		"where risk_id = 8 " +
		"and clmst_id = 1 " +
		"order by claim_no desc ";
	// *** Fim das consultas da base BVP. ***
	
	
	
	// *** Início das consultas da base GARANTIAS. ***
	public static final String BUSCA_CERTIF_GARANTIAS_ROUBO_OU_FURTO_QUALIF_SEM_SINISTRO =
		" select distinct top 1 pc.policy_no " +
		" from policy_certificate pc (nolock) " +
		" inner join master_policy mp (nolock) on mp.mp_no = pc.mp_no and mp.mp_endors_no = pc.mp_endors_no " +
		" inner join mp_claim_rules mcr (nolock) on mcr.mp_no = mp.mp_no and mcr.mp_endors_no = mp.mp_endors_no " +
		" left join claim c (nolock) on c.policy_no = pc.policy_no " +
		" inner join policy_certif_prod_rsk_covrge pcx (nolock) on pcx.policy_no = pc.policy_no and pcx.polcrt_endors_no = pc.polcrt_endors_no and pcx.risk_id = 32 " +
		" inner join partner p (nolock) " +
		" on p.partner_id = mp.partner_id " +
		" inner join letter l (nolock) " +
		" on l.partner_id = p.partner_id " +
		" where c.policy_no is null " +
		" and pc.polcrt_ins_dtm > '20180101' " +
		" and pc.polst_id = 1 " +
		" and pcx.pcprc_inssured_amount is not null " +
		" and mcr.clmrls_instmnt_qty = 0 " +
		" and mcr.clmrls_payment_base = 4 " +
		" and getdate() between pc.polcrt_eff_dtm and pc.polcrt_exp_dtm " +
		" and pc.polcrt_del_fg = 'N' " +
		" and mp.mp_del_fg = 'N' " +
		" and pcx.pcprc_del_fg = 'N' " +
		" and l.letter_del_fg = 'N' " +
		" and l.letter_name like '%documento%' ";
	
	
	public static final String BUSCA_SINISTRO_GARANTIAS_ROUBO_OU_FURTO_QUALIF_SEM_SINISTRO =
		" select top 1 c.claim_no " +
		" from claim c " +
		" where c.risk_id = 32 " +
		" and c.clmst_id = 1 " +
		" order by c.claim_no desc ";
	// *** Fim das consultas da base GARANTIAS. ***
	
	
	
}
