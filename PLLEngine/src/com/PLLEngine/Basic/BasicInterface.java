//Peter
package com.PLLEngine.Basic;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.PLLEngine.Basic.ConsoleOutput.BasicSystemOutput;

public interface BasicInterface extends BasicSystemOutput {
	public default void setWindowsLook() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			System.err.println("could not use windows Look");
		}
	};
}
