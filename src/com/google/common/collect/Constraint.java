/*
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.collect;

/**
 * A constraint that an element must satisfy in order to be added to a
 * collection. For example, {@link Constraints#NOT_NULL}, which prevents a
 * collection from including any null elements, could be implemented like this:
 *
 * <pre>  public void checkElement(Object element) {
 *    if (element == null) {
 *      throw new NullPointerException();
 *    }
 *  }</pre>
 *
 * <p>In order to be effective, constraints should be deterministic; that is,
 * they should not depend on state that can change (such as external state,
 * random variables, and time) and should only depend on the value of the
 * passed-in element. A non-deterministic constraint cannot reliably enforce
 * that all the collection's elements meet the constraint, since the constraint
 * is only enforced when elements are added.
 *
 * @see Constraints
 * @see MapConstraint
 * @author Mike Bostock
 */
public interface Constraint<E> {
  /**
   * Throws a suitable {@code RuntimeException} if the specified element is
   * illegal. Typically this is either a {@link NullPointerException}, an
   * {@link IllegalArgumentException}, or a {@link ClassCastException}, though
   * an application-specific exception class may be used if appropriate.
   */
  void checkElement(E element);

  /**
   * Returns a brief human readable description of this constraint, such as
   * "Not null" or "Positive number".
   */
  String toString();
}
