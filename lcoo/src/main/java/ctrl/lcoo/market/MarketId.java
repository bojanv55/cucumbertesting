package ctrl.lcoo.market;

public class MarketId implements LineId {
	private String value;

	public MarketId(String value){
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "MarketId{" +
				"value='" + value + '\'' +
				'}';
	}
}
