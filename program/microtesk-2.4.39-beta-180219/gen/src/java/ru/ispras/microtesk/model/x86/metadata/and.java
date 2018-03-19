/*
 * Copyright (c) Institute for System Programming of the Russian Academy of Sciences
 * All Rights Reserved
 *
 * Institute for System Programming of the Russian Academy of Sciences (ISP RAS)
 * 25 Alexander Solzhenitsyn st., Moscow, 109004, Russia
 * http://www.ispras.ru
 *
 * The present file was automatically generated on the basis of formal specifications.
 * It is distributed under the same terms and conditions as the derived specifications.
 *
 * N.B. PLEASE DO NOT MODIFY THIS FILE.
 */

package ru.ispras.microtesk.model.x86.metadata;

import ru.ispras.microtesk.model.metadata.MetaGroup;

/**
 * The {@code and} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class and extends MetaGroup {
  private static and instance = null;

  public static and get() {
    if (null == instance) {
      instance = new and();
    }
    return instance;
  }

  private and() {
    super(
        MetaGroup.Kind.OP,
        "and",
        and_r8r8.get(),
        and_m8r8.get(),
        and_r8m8.get(),
        and_r8i8.get(),
        and_m8i8.get(),
        and_r16r16.get(),
        and_m16r16.get(),
        and_r16m16.get(),
        and_r16i16.get(),
        and_m16i16.get()
        );
  }
}
