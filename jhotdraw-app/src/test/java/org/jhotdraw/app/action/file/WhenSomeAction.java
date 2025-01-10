package org.jhotdraw.app.action.file;

import com.tngtech.jgiven.Stage;

public class WhenSomeAction extends Stage<WhenSomeAction> {
	public WhenSomeAction some_action() {
		return this.self();
	}

	public WhenSomeAction closing_the_file() {
		return this.self();
	}
}
