package ctrl.lcoo.market.outcome;

public class PlayerOutcomeId implements OutcomeId {
	private String value;

	public PlayerOutcomeId(String value){
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}
}
