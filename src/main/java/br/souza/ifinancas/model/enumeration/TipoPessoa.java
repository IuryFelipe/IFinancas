package br.souza.ifinancas.model.enumeration;

public enum TipoPessoa {
	FISICA(1, "Fisica"),
	JURIDICA(2, "Juridica");
	
	private int value;
	private String label;
	
	private TipoPessoa(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return value;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static TipoPessoa valueOf(Integer value) {
		if (value == null)
			return null;
		
		for (TipoPessoa tipoPessoa : values()) {
			if (tipoPessoa.getValue() == value) {
				return tipoPessoa;
			}
		}
		return null;
	}
}
