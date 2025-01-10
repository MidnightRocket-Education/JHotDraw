package org.jhotdraw.app.action.file;

import com.tngtech.jgiven.Stage;

public class GivenSomeState extends Stage<GivenSomeState> {
	public GivenSomeState some_state() {
		return this.self();
	}

	public GivenSomeState a_file_with_unsaved_changes() {
		return this.self();
	}
}
