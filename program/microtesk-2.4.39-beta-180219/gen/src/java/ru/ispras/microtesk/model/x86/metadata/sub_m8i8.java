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
 * The {@code sub_m8i8} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class sub_m8i8 extends MetaOperation {
  private static sub_m8i8 instance = null;

  public static sub_m8i8 get() {
    if (null == instance) {
      instance = new sub_m8i8();
    }
    return instance;
  }

  private sub_m8i8() {
    super(
        "sub_m8i8",
        "sub_m8i8",
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
    addArgument(new MetaArgument("op2", IMM8.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_sub_m8i8.get());
  }

  private static final class instruction_sub_m8i8 extends MetaOperation {
    private static instruction_sub_m8i8 instance = null;

    public static instruction_sub_m8i8 get() {
      if (null == instance) {
        instance = new instruction_sub_m8i8();
      }
      return instance;
    }

    private instruction_sub_m8i8() {
      super(
          "sub_m8i8",
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
      addArgument(new MetaArgument("op2", IMM8.get(), ArgumentMode.IN));
    }
  }
}
