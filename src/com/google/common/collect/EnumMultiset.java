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

import static com.google.common.base.Preconditions.checkArgument;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Multiset implementation backed by an {@link EnumMap}.
 *
 * @author Jared Levy
 */
public final class EnumMultiset<E extends Enum<E>>
    extends AbstractMapBasedMultiset<E> {
  /** Creates an empty {@code EnumMultiset}. */
  public EnumMultiset(Class<E> type) {
    super(new EnumMap<E, AtomicInteger>(type));
  }

  /**
   * Creates a new {@code EnumMultiset} containing the specified elements.
   *
   * @param elements the elements that the multiset should contain
   * @throws IllegalArgumentException if {@code elements} is empty
   */
  public EnumMultiset(Iterable<E> elements) {
    this(findClass(elements));
    Iterables.addAll(this, elements);
  }

  /**
   * Determine the class of the first element in an {@link Iterable}.
   *
   * @param elements the elements to examine
   * @return the {@link Class} of the first element
   * @throws IllegalArgumentException if {@code elements} is empty
   */
  private static <E extends Enum<E>> Class<E> findClass(Iterable<E> elements) {
    Iterator<E> iterator = elements.iterator();
    checkArgument(iterator.hasNext(),
        "EnumMultiset constructor passed empty Iterable");
    return iterator.next().getDeclaringClass();
  }

  private static final long serialVersionUID = -3657226655572850764L;
}
