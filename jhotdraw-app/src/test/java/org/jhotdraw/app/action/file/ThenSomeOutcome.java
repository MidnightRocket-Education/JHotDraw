package org.jhotdraw.app.action.file;

import com.tngtech.jgiven.Stage;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {
	public ThenSomeOutcome some_outcome() {
		return this.self();
	}

	public ThenSomeOutcome ask_to_save_changes() {
		return this.self();
	}
}
