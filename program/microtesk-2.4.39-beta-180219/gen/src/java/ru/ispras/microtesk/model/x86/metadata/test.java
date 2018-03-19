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
 * The {@code test} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class test extends MetaGroup {
  private static test instance = null;

  public static test get() {
    if (null == instance) {
      instance = new test();
    }
    return instance;
  }

  private test() {
    super(
        MetaGroup.Kind.OP,
        "test",
        test_r8r8.get(),
        test_m8r8.get(),
        test_r8i8.get(),
        test_m8i8.get(),
        test_r16r16.get(),
        test_m16r16.get(),
        test_r16i16.get(),
        test_m16i16.get()
        );
  }
}
