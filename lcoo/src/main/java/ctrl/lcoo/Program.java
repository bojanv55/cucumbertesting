package ctrl.lcoo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import ctrl.lcoo.dto.market.LinesMarketDto;
import ctrl.lcoo.dto.market.MarketDto;
import ctrl.lcoo.dto.market.OutcomeDto;
import ctrl.lcoo.market.Line;
import ctrl.lcoo.market.LineId;
import ctrl.lcoo.market.MarketId;
import ctrl.lcoo.market.MultiLine;
import ctrl.lcoo.market.SingleLine;
import ctrl.lcoo.market.TypeKey;
import ctrl.lcoo.market.outcome.DefaultOutcomeId;
import ctrl.lcoo.market.outcome.Odds;
import ctrl.lcoo.market.outcome.Outcome;

public class Program {


	public static void importMarket(){
		MarketDto marketDto = new MarketDto();
		marketDto.marketId = 591;
		OutcomeDto o1 = new OutcomeDto();
		o1.id = 1;
		o1.odds = 1.1;
		OutcomeDto o2 = new OutcomeDto();
		o2.id = 2;
		o2.odds = 1.1;
		OutcomeDto o3 = new OutcomeDto();
		o3.id = 3;
		o3.odds = 1.1;
		marketDto.outcomes.addAll(Arrays.asList(
			o1, o2, o3
		));


		MarketId threeWayId = new MarketId(String.valueOf(marketDto.marketId));
		Line<MarketId> threeWay = new SingleLine.Builder<>(threeWayId)
				.addOutcomes(marketDto.outcomes.stream()
						.map(o -> new Outcome(new DefaultOutcomeId(String.valueOf(o.id)), new Odds(o.odds)))
						.collect(Collectors.toSet())
				)
				.build();

		System.out.println(threeWay);

		//---------------------
		LinesMarketDto lmd = new LinesMarketDto();
		lmd.marketId = 161;
		OutcomeDto o4 = new OutcomeDto();
		o4.id = 4;
		o4.odds = 1.1;
		OutcomeDto o5 = new OutcomeDto();
		o5.id = 5;
		o5.odds = 1.1;
		lmd.typeKeysToOutcome.put(new String[]{"1.5"}, o4);
		lmd.typeKeysToOutcome.put(new String[]{"1.5"}, o5);
	}

	public static void exportMarket(){

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


		LinesMarketDto lmdto = new LinesMarketDto();
		lmdto.marketId = Integer.parseInt(totals.getLineId().getValue());	//parse market id to string

		System.out.println("EXPORT");
		Map<LineId[], Set<Outcome>> otc = totals.getOutcomes();
		Iterator<LineId[]> i = otc.keySet().iterator();
		System.out.println(Arrays.toString(i.next()));
		System.out.println(Arrays.toString(i.next()));
		System.out.println(totals.getOutcomes());

	}

	public static void main(String[] args) {
		importMarket();
		exportMarket();

		MarketId threeWayId = new MarketId("591");
		Line<MarketId> threeWay = new SingleLine.Builder<>(threeWayId)
				.addOutcome(new Outcome(new DefaultOutcomeId("1"), new Odds(1.23)))
				.addOutcome(new Outcome(new DefaultOutcomeId("2"), new Odds(7.52)))
				.addOutcome(new Outcome(new DefaultOutcomeId("3"), new Odds(9.44)))
				.build();

		System.out.println(threeWay);

		threeWay = threeWay.adjustOutcome(new DefaultOutcomeId("2"), new Odds(1.22));

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

		totals = totals.adjustOutcome(new DefaultOutcomeId("5"), new Odds(111.0), new TypeKey("1.5"));

		System.out.println(totals);

	}
}
