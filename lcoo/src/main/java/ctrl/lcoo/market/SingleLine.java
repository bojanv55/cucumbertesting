package ctrl.lcoo.market;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import ctrl.lcoo.market.outcome.Odds;
import ctrl.lcoo.market.outcome.Outcome;
import ctrl.lcoo.market.outcome.OutcomeId;

public class SingleLine<T extends LineId> implements Line<T> {
	private T lineId;
	private Set<Outcome> outcomes;

	private SingleLine(Builder<T> builder){
		lineId = builder.lineId;
		outcomes = builder.outcomes;
	}

	@Override
	public T getLineId() {
		return lineId;
	}

	@Override
	public Line<T> adjustOdds(OutcomeId outcomeId, Odds odds, TypeKey... typeKeys) {
		Set<Outcome> filteredOutcomes = outcomes.stream().filter(o -> !Objects.equals(o.outcomeId(), outcomeId)).collect(Collectors.toSet());
		return new Builder<>(lineId)
				.addOutcomes(filteredOutcomes)
				.addOutcome(new Outcome(outcomeId, odds))
				.build();
	}

	@Override
	public String toString() {
		return "SingleLine{" +
				"lineId=" + lineId +
				", outcomes=" + outcomes +
				'}';
	}

	public static class Builder<T extends LineId> {
		private T lineId;
		private Set<Outcome> outcomes = new HashSet<>();

		public Builder(T lineId){
			this.lineId = lineId;
		}

		public Builder<T> addOutcomes(Collection<Outcome> outcomes){
			this.outcomes.addAll(outcomes);
			return this;
		}

		public Builder<T> addOutcome(Outcome outcome){
			outcomes.add(outcome);
			return this;
		}

		public SingleLine<T> build(){
			return new SingleLine<>(this);
		}
	}
}
