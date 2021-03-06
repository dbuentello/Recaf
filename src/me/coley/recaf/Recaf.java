package me.coley.recaf;

import me.coley.event.Bus;
import me.coley.recaf.bytecode.analysis.Hierarchy;
import me.coley.recaf.ui.FxWindow;

public class Recaf {
	public static final String VERSION = "1.6.2";

	public static void main(String[] args) {
		if (!DependencyChecks.check()) {
			return;
		}
		// run update check (if enabled)
		Updater.run(args);
		// Register hierarchy listeners by calling an arbitrary method in the
		// class. This will load it.
		Hierarchy.getStatus();
		// start main window
		Bus.subscribe(new InitListener(args));
		FxWindow.init(args);
	}

	
}
