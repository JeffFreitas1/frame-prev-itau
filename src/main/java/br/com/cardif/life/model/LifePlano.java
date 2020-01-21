package br.com.cardif.life.model;

public class LifePlano {

	
		private String risco;
		private String cobertura;
		private Double premio;
		private String plano;
		private String lmi;
			
				
		public LifePlano(String risco, String cobertura, Double premio, String lmi,String plano) {
			this.risco = risco;
			this.cobertura = cobertura;
			this.premio = premio;
			this.lmi = lmi;
			this.plano = plano;
		}
		
		public String getPlano() {
			return plano;
		}

		public void setPlano(String plano) {
			this.plano = plano;
		}

		public String getRisco() {
			return risco;
		}
		public void setRisco(String risco) {
			this.risco = risco;
		}
		public String getCobertura() {
			return cobertura;
		}
		public void setCobertura(String cobertura) {
			this.cobertura = cobertura;
		}
		public Double getPremio() {
			return premio;
		}
		public void setPremio(Double premio) {
			this.premio = premio;
		}
		public String getLmi() {
			return lmi;
		}
		public void setLmi(String lmi) {
			this.lmi = lmi;
		}
		
		
		
		
}
