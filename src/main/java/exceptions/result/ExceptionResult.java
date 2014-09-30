package exceptions.result;

import java.util.List;

public interface ExceptionResult {

	public void addResult(String result);

	public List<String> getResults();

	public String getLastResult();

}
