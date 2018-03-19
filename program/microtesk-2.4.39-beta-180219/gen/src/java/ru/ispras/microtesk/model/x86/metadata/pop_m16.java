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

import static ru.ispras.microtesk.model.x86.TypeDefs.*;

import ru.ispras.microtesk.model.ArgumentMode;
import ru.ispras.microtesk.model.metadata.MetaArgument;
import ru.ispras.microtesk.model.metadata.MetaOperation;
import ru.ispras.microtesk.model.data.Type;

/**
 * The {@code pop_m16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class pop_m16 extends MetaOperation {
  private static pop_m16 instance = null;

  public static pop_m16 get() {
    if (null == instance) {
      instance = new pop_m16();
    }
    return instance;
  }

  private pop_m16() {
    super(
        "pop_m16",
        "pop_m16",
        false,
        false,
        false,
        false,
        true,
        true,
        8
        );
    addArgument(new MetaArgument("seg_ovrd", RSEG16.get(), ArgumentMode.IN));
    addArgument(new MetaArgument("dst", MOFFS.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_pop_m16.get());
  }

  private static final class instruction_pop_m16 extends MetaOperation {
    private static instruction_pop_m16 instance = null;

    public static instruction_pop_m16 get() {
      if (null == instance) {
        instance = new instruction_pop_m16();
      }
      return instance;
    }

    private instruction_pop_m16() {
      super(
          "pop_m16",
          "instruction",
          true,
          true,
          true,
          false,
          true,
          true,
          8
          );
      addArgument(new MetaArgument("seg_ovrd", RSEG16.get(), ArgumentMode.IN));
      addArgument(new MetaArgument("dst", MOFFS.get(), ArgumentMode.IN));
    }
  }
}
