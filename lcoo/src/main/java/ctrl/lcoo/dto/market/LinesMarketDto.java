package ctrl.lcoo.dto.market;

import java.util.HashMap;
import java.util.Map;

public class LinesMarketDto {
	public int marketId;
	public Map<String[], OutcomeDto> typeKeysToOutcome = new HashMap<>();
}
