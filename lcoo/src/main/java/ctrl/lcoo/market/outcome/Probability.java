package ctrl.lcoo.market.outcome;

import lombok.Data;

@Data
public class Probability {
	private final Double value;

	public static Probability missing(){
		return new Probability(null);
	}
}
