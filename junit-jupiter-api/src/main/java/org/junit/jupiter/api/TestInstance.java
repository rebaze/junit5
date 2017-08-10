/*
 * Copyright 2015-2017 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.jupiter.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code @TestInstance} is a type-level annotation that is used to configure
 * the {@linkplain Lifecycle lifecycle} of test instances for the annotated
 * test class or test interface.
 *
 * <p>If {@code @TestInstance} is not declared on a test class or implemented
 * test interface, the lifecycle mode will implicitly default to
 * {@link Lifecycle#PER_METHOD PER_METHOD}. Note, however, that an explicit
 * lifecycle mode is <em>inherited</em> within a test class hierarchy.
 *
 * <h3>Use Cases</h3>
 * <p>Setting the test instance lifecycle mode to {@link Lifecycle#PER_CLASS
 * PER_CLASS} enables the following features.
 * <ul>
 * <li>Shared test instance state between test methods in a given test class
 * as well as between non-static {@link BeforeAll @BeforeAll} and
 * {@link AfterAll @AfterAll} methods in the test class.</li>
 * <li>Declaration of {@link BeforeAll @BeforeAll} and {@link AfterAll @AfterAll}
 * methods in {@link Nested @Nested} test classes.</li>
 * <li>Declaration of {@link BeforeAll @BeforeAll} and {@link AfterAll @AfterAll}
 * on interface {@code default} methods.</li>
 * <li>Simplified declaration of {@link BeforeAll @BeforeAll} and
 * {@link AfterAll @AfterAll} methods in test classes implemented with the Kotlin
 * programming language.</li>
 * </ul>
 *
 * <p>{@code @TestInstance} may also be used as a meta-annotation in order to
 * create a custom <em>composed annotation</em> that inherits the semantics
 * of {@code @TestInstance}.
 *
 * @since 5.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TestInstance {

	/**
	 * Enumeration of test instance lifecycle <em>modes</em>.
	 *
	 * @see #PER_METHOD
	 * @see #PER_CLASS
	 */
	enum Lifecycle {

		/**
		 * When using this mode, a new test instance will be created once per test class.
		 *
		 * @see #PER_METHOD
		 */
		PER_CLASS,

		/**
		 * When using this mode, a new test instance will be created for each test method
		 * or test factory method.
		 *
		 * <p>This mode is analogous to the behavior found in JUnit versions 1 through 4.
		 *
		 * @see #PER_CLASS
		 */
		PER_METHOD;

	}

	/**
	 * The test instance lifecycle <em>mode</em> to use.
	 */
	Lifecycle value();

}
