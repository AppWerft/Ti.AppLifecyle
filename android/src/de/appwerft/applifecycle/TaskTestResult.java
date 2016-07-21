package de.appwerft.applifecycle;

public final class TaskTestResult {
	private final boolean isForeground;
	private final String packageName;

	public TaskTestResult(boolean isForeground, String packageName) {
		this.isForeground = isForeground;
		this.packageName = packageName;
	}

	public boolean getIsForeground() {
		return isForeground;
	}

	public String getPackageName() {
		return packageName;
	}
}