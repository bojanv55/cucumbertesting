package ctrl.lcoo;

import ctrl.lcoo.market.Line;
import ctrl.lcoo.market.MarketId;
import ctrl.lcoo.market.SingleLine;
import ctrl.lcoo.market.outcome.DefaultOutcomeId;
import ctrl.lcoo.market.outcome.Odds;
import ctrl.lcoo.market.outcome.Outcome;

public class Program {
	public static void main(String[] args) {
		MarketId threeWayId = new MarketId("591");
		Line<MarketId> threeWay = new SingleLine.Builder<>(threeWayId)
				.addOutcome(new Outcome(new DefaultOutcomeId("1"), new Odds(1.23)))
				.addOutcome(new Outcome(new DefaultOutcomeId("2"), new Odds(7.52)))
				.addOutcome(new Outcome(new DefaultOutcomeId("3"), new Odds(9.44)))
				.build();

		System.out.println(threeWay);

		threeWay = threeWay.adjustOdds(new DefaultOutcomeId("2"), new Odds(1.22));

		System.out.println(threeWay);
	}
}
