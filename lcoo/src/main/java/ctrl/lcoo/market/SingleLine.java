package ctrl.lcoo.market;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import ctrl.lcoo.market.outcome.Odds;
import ctrl.lcoo.market.outcome.Outcome;
import ctrl.lcoo.market.outcome.OutcomeId;
import ctrl.lcoo.market.outcome.Probability;
import lombok.ToString;

@ToString
public class SingleLine<T extends LineId> implements Line<T> {
	private final T lineId;
	private final Set<Outcome> outcomes;

	private SingleLine(Builder<T> builder){
		lineId = builder.lineId;
		outcomes = builder.outcomes;
	}

	@Override
	public T getLineId() {
		return lineId;
	}

	@Override
	public Line<? extends LineId> getLine(TypeKey... typeKeys) {
		return this;
	}

	@Override
	public Line<T> adjustOutcome(OutcomeId outcomeId, Odds odds, TypeKey... typeKeys) {
		Set<Outcome> filteredOutcomes = outcomes.stream().filter(o -> !Objects.equals(o.getOutcomeId(), outcomeId)).collect(Collectors.toSet());
		return new Builder<>(lineId)
				.addOutcomes(filteredOutcomes)
				.addOutcome(new Outcome(outcomeId, odds, Probability.missing()))
				.build();
	}

	@Override
	public Map<LineId[], Set<Outcome>> getOutcomes() {
		Map<LineId[], Set<Outcome>> lineIdsToOutcomes = new HashMap<>();
		lineIdsToOutcomes.put(null, outcomes);	//caller of this (if any) will map this to proper type-key
		return lineIdsToOutcomes;
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
