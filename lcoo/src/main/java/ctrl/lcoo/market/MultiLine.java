package ctrl.lcoo.market;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import ctrl.lcoo.market.outcome.Odds;
import ctrl.lcoo.market.outcome.Outcome;
import ctrl.lcoo.market.outcome.OutcomeId;
import lombok.ToString;

@ToString
public class MultiLine<T extends LineId> implements Line<T> {
	private final T lineId;
	private final Map<TypeKey, Line<? extends TypeKey>> typeKeyedLines;

	private MultiLine(Builder<T> builder){
		lineId = builder.lineId;
		typeKeyedLines = builder.typeKeyedLines;
	}

	@Override
	public T getLineId() {
		return lineId;
	}

	@Override
	public Line<? extends LineId> getLine(TypeKey... typeKeys) {
		if(typeKeys.length != 0) {
			TypeKey localTypeKey = typeKeys[0];
			if (typeKeyedLines.containsKey(localTypeKey)) {
				return typeKeyedLines.get(localTypeKey).getLine(typeKeys);	//TODO: cut coordinates for 1 element
			}
			throw new LineNotFoundException();
		}
		throw new IllegalArgumentException("At least one typeKey must be specified.");
	}

	@Override
	public Line<T> adjustOutcome(OutcomeId outcomeId, Odds odds, TypeKey... typeKeys) {
		if(typeKeys.length != 0) {
			TypeKey localTypeKey = typeKeys[0];
			if (typeKeyedLines.containsKey(localTypeKey)) {
				Line<? extends TypeKey> updatedLine = typeKeyedLines.get(localTypeKey).adjustOutcome(outcomeId, odds, typeKeys);
				return new Builder<>(lineId)
						.addLines(typeKeyedLines.values().stream().filter(line -> !Objects.equals(line.getLineId(), localTypeKey)).collect(Collectors.toSet()))
						.addLine(updatedLine)
						.build();
			}
			throw new LineNotFoundException();
		}
		throw new IllegalArgumentException("At least one typeKey must be specified.");
	}

	@Override
	public Map<LineId[], Set<Outcome>> getOutcomes() {
		Map<LineId[], Set<Outcome>> lineIdsToOutcomes = new HashMap<>();
		typeKeyedLines.values().forEach(l -> {
			Map<LineId[], Set<Outcome>> subLineIdsToOutcomes = l.getOutcomes();
			lineIdsToOutcomes.putAll(subLineIdsToOutcomes);	//TODO: mapp inner
		});
		return lineIdsToOutcomes;
	}

	public static class Builder<T extends LineId> {
		private T lineId;
		private Map<TypeKey, Line<? extends TypeKey>> typeKeyedLines = new HashMap<>();

		public Builder(T lineId){
			this.lineId = lineId;
		}

		public Builder<T> addLines(Collection<Line<? extends TypeKey>> lines){
			lines.forEach(line -> typeKeyedLines.put(line.getLineId(), line));
			return this;
		}

		public Builder<T> addLine(Line<? extends TypeKey> line){
			typeKeyedLines.put(line.getLineId(), line);
			return this;
		}

		public MultiLine<T> build(){
			return new MultiLine<>(this);
		}
	}
}
