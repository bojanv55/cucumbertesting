package ctrl.lcoo.market;

public class TypeKey implements LineId {
	private String value;

	public TypeKey(String value){
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}
}
