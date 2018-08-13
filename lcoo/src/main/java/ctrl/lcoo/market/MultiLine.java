package ctrl.lcoo.market;

import ctrl.lcoo.market.outcome.Odds;
import ctrl.lcoo.market.outcome.OutcomeId;

public class MultiLine<T extends LineId> implements Line<T> {
	private T lineId;

	@Override
	public T getLineId() {
		return lineId;
	}

	@Override
	public Line<T> adjustOdds(OutcomeId outcomeId, Odds odds, TypeKey... typeKeys) {
		return null;
	}
}
