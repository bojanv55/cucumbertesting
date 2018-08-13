package ctrl.lcoo.market.outcome;

public class Odds {
	private Double value;

	public Odds(Double value){
		this.value = value;
	}

	public Double value() {
		return value;
	}

	@Override
	public String toString() {
		return "Odds{" +
				"value=" + value +
				'}';
	}
}
