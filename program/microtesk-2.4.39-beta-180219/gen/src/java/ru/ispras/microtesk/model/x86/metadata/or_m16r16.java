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
 * The {@code or_m16r16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class or_m16r16 extends MetaOperation {
  private static or_m16r16 instance = null;

  public static or_m16r16 get() {
    if (null == instance) {
      instance = new or_m16r16();
    }
    return instance;
  }

  private or_m16r16() {
    super(
        "or_m16r16",
        "or_m16r16",
        false,
        false,
        false,
        false,
        false,
        true,
        8
        );
    addArgument(new MetaArgument("seg_ovrd", RSEG16.get(), ArgumentMode.IN));
    addArgument(new MetaArgument("op1", MOFFS.get(), ArgumentMode.IN));
    addArgument(new MetaArgument("op2", R16.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_or_m16r16.get());
  }

  private static final class instruction_or_m16r16 extends MetaOperation {
    private static instruction_or_m16r16 instance = null;

    public static instruction_or_m16r16 get() {
      if (null == instance) {
        instance = new instruction_or_m16r16();
      }
      return instance;
    }

    private instruction_or_m16r16() {
      super(
          "or_m16r16",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          true,
          8
          );
      addArgument(new MetaArgument("seg_ovrd", RSEG16.get(), ArgumentMode.IN));
      addArgument(new MetaArgument("op1", MOFFS.get(), ArgumentMode.IN));
      addArgument(new MetaArgument("op2", R16.get(), ArgumentMode.IN));
    }
  }
}
