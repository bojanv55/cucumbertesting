package ctrl.lcoo.market.outcome;

import java.util.Objects;

public class DefaultOutcomeId implements OutcomeId {
	private String value;

	public DefaultOutcomeId(String value){
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		DefaultOutcomeId that = (DefaultOutcomeId)o;
		return Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {

		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "DefaultOutcomeId{" +
				"value='" + value + '\'' +
				'}';
	}
}
