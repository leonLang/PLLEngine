//Peter
package com.PLLEngine.Basic.ConsoleOutput;
//can be used but not very important

public interface BasicSystemOutput {
	public default void sysout(String message) {
		System.out.println(message);
	};
	public default void sysout(Object object) {
		System.out.println(object);
	};
}
