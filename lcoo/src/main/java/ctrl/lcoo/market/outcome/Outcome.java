package ctrl.lcoo.market.outcome;

import java.util.Objects;

public class Outcome {
	private OutcomeId outcomeId;
	private Odds odds;
	private Probability probability;

	public Outcome(OutcomeId outcomeId, Odds odds){
		this.outcomeId = outcomeId;
		this.odds = odds;
	}

	public OutcomeId outcomeId(){
		return outcomeId;
	}

	public Odds odds(){
		return odds;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Outcome outcome = (Outcome)o;
		return Objects.equals(outcomeId, outcome.outcomeId);
	}

	@Override
	public int hashCode() {

		return Objects.hash(outcomeId);
	}

	@Override
	public String toString() {
		return "Outcome{" +
				"outcomeId=" + outcomeId +
				", odds=" + odds +
				'}';
	}
}
