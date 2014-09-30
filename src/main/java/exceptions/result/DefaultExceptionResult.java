package exceptions.result;

import java.util.LinkedList;
import java.util.List;

public class DefaultExceptionResult implements ExceptionResult {

	private final List<String> results = new LinkedList<>();

	@Override
	public void addResult(String string) {
		results.add(string);
	}

	@Override
	public List<String> getResults() {
		return results;
	}

	@Override
	public String getLastResult() {
		return getResults().get(getResults().size() - 1);
	}

}
