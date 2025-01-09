package org.jhotdraw.util;

public enum ResourceBundleID {
	DRAW_LABELS("org.jhotdraw.draw.Labels"),
	GUI_LABELS("org.jhotdraw.gui.Labels"),
	ACTION_LABELS("org.jhotdraw.action.Labels"),
	APP_LABELS("org.jhotdraw.app.labels");

	private final String id;

	private ResourceBundleID(final String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}
}
