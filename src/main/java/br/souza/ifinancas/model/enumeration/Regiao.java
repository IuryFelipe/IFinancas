package br.souza.ifinancas.model.enumeration;

public enum Regiao {
	NORTE(1, "Norte"),
	NORDESTE(2, "Nordeste"),
	CENTROESTE(3, "Centroeste"),
	SUL(4, "Sul"),
	SUDESTE(5, "Sudeste");
	
	private int value;
	private String label;
	
	private Regiao(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

	
	public static Regiao valueOf(Integer value) {
		if(value == null)
			return null;
		
		for (Regiao regiao: values()) {
			if(regiao.getValue() == value) {
				return regiao;
			}
				
		}
		return null;
	}
	
	
	
	
}
