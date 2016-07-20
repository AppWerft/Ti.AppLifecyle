package de.appwerft.applifecycle;

public final class TaskTestResult {
	private final boolean isForground;
	private final String packageName;

	public TaskTestResult(boolean isForground, String packageName) {
		this.isForground = isForground;
		this.packageName = packageName;
	}

	public boolean getIsForground() {
		return isForground;
	}

	public String getPackageName() {
		return packageName;
	}
}