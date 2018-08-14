package ctrl.lcoo.market;

import java.util.Map;
import java.util.Set;

import ctrl.lcoo.market.outcome.Odds;
import ctrl.lcoo.market.outcome.Outcome;
import ctrl.lcoo.market.outcome.OutcomeId;

public interface Line<T extends LineId> {
	T getLineId();
	Line<? extends LineId> getLine(TypeKey... typeKeys);
	Line<T> adjustOutcome(OutcomeId outcomeId, Odds odds, TypeKey ...typeKeys);
	//will not contain MarketId in LineId[] coordinates. Only TypeKeys. If called on 3way (since no type-keys), will return (null) => outcomes
	Map<LineId[], Set<Outcome>> getOutcomes();
}
