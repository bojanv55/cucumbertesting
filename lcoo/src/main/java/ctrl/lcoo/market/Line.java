package ctrl.lcoo.market;

import ctrl.lcoo.market.outcome.Odds;
import ctrl.lcoo.market.outcome.OutcomeId;

public interface Line<T extends LineId> {
	T getLineId();
	Line<T> adjustOdds(OutcomeId outcomeId, Odds odds, TypeKey ...typeKeys);
}
