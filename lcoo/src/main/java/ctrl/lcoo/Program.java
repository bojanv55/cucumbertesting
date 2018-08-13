package ctrl.lcoo;

import ctrl.lcoo.market.Line;
import ctrl.lcoo.market.MarketId;
import ctrl.lcoo.market.MultiLine;
import ctrl.lcoo.market.SingleLine;
import ctrl.lcoo.market.TypeKey;
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


		//----

		TypeKey pointFiveTK = new TypeKey("0.5");
		Line<TypeKey> pointFiveLine = new SingleLine.Builder<>(pointFiveTK)
				.addOutcome(new Outcome(new DefaultOutcomeId("4"), new Odds(1.23)))
				.addOutcome(new Outcome(new DefaultOutcomeId("5"), new Odds(7.52)))
				.build();

		TypeKey onePointFiveTK = new TypeKey("1.5");
		Line<TypeKey> onePointFiveLine = new SingleLine.Builder<>(onePointFiveTK)
				.addOutcome(new Outcome(new DefaultOutcomeId("4"), new Odds(8.0)))
				.addOutcome(new Outcome(new DefaultOutcomeId("5"), new Odds(9.0)))
				.build();

		MarketId totalsMarketId = new MarketId("161");
		Line<MarketId> totals = new MultiLine.Builder<>(totalsMarketId)
				.addLine(pointFiveLine)
				.addLine(onePointFiveLine)
				.build();

		System.out.println(totals);

		totals = totals.adjustOdds(new DefaultOutcomeId("5"), new Odds(111.0), new TypeKey("1.5"));

		System.out.println(totals);

	}
}
