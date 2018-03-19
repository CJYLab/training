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
 * The {@code sub} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class sub extends MetaGroup {
  private static sub instance = null;

  public static sub get() {
    if (null == instance) {
      instance = new sub();
    }
    return instance;
  }

  private sub() {
    super(
        MetaGroup.Kind.OP,
        "sub",
        sub_m8r8.get(),
        sub_r8r8.get(),
        sub_r8m8.get(),
        sub_r8i8.get(),
        sub_m8i8.get(),
        sub_r16r16.get(),
        sub_r16m16.get(),
        sub_r16i16.get(),
        sub_m16i16.get(),
        sub_m16r16.get()
        );
  }
}
