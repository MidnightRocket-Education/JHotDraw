package org.jhotdraw.app.action.file;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

class CloseFileActionJGivenTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {
	@Test
	void onCloseFileWithUnsavedTests() {
		given().a_file_with_unsaved_changes();
		when().closing_the_file();
		then().ask_to_save_changes();
	}
}