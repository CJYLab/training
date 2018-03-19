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
 * The {@code sbb_r16m16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class sbb_r16m16 extends MetaOperation {
  private static sbb_r16m16 instance = null;

  public static sbb_r16m16 get() {
    if (null == instance) {
      instance = new sbb_r16m16();
    }
    return instance;
  }

  private sbb_r16m16() {
    super(
        "sbb_r16m16",
        "sbb_r16m16",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("seg_ovrd", RSEG16.get(), ArgumentMode.IN));
    addArgument(new MetaArgument("op1", R16.get(), ArgumentMode.INOUT));
    addArgument(new MetaArgument("op2", MOFFS.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_sbb_r16m16.get());
  }

  private static final class instruction_sbb_r16m16 extends MetaOperation {
    private static instruction_sbb_r16m16 instance = null;

    public static instruction_sbb_r16m16 get() {
      if (null == instance) {
        instance = new instruction_sbb_r16m16();
      }
      return instance;
    }

    private instruction_sbb_r16m16() {
      super(
          "sbb_r16m16",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("seg_ovrd", RSEG16.get(), ArgumentMode.IN));
      addArgument(new MetaArgument("op1", R16.get(), ArgumentMode.INOUT));
      addArgument(new MetaArgument("op2", MOFFS.get(), ArgumentMode.IN));
    }
  }
}
