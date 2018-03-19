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
 * The {@code xor_r8r8} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class xor_r8r8 extends MetaOperation {
  private static xor_r8r8 instance = null;

  public static xor_r8r8 get() {
    if (null == instance) {
      instance = new xor_r8r8();
    }
    return instance;
  }

  private xor_r8r8() {
    super(
        "xor_r8r8",
        "xor_r8r8",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("op1", R8.get(), ArgumentMode.INOUT));
    addArgument(new MetaArgument("op2", R8.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_xor_r8r8.get());
  }

  private static final class instruction_xor_r8r8 extends MetaOperation {
    private static instruction_xor_r8r8 instance = null;

    public static instruction_xor_r8r8 get() {
      if (null == instance) {
        instance = new instruction_xor_r8r8();
      }
      return instance;
    }

    private instruction_xor_r8r8() {
      super(
          "xor_r8r8",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("op1", R8.get(), ArgumentMode.INOUT));
      addArgument(new MetaArgument("op2", R8.get(), ArgumentMode.IN));
    }
  }
}
