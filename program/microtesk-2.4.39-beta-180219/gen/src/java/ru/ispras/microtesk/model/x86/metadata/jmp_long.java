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
 * The {@code jmp_long} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class jmp_long extends MetaOperation {
  private static jmp_long instance = null;

  public static jmp_long get() {
    if (null == instance) {
      instance = new jmp_long();
    }
    return instance;
  }

  private jmp_long() {
    super(
        "jmp_long",
        "jmp_long",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("rel", SWORD));

    addShortcut("#root", instruction_jmp_long.get());
  }

  private static final class instruction_jmp_long extends MetaOperation {
    private static instruction_jmp_long instance = null;

    public static instruction_jmp_long get() {
      if (null == instance) {
        instance = new instruction_jmp_long();
      }
      return instance;
    }

    private instruction_jmp_long() {
      super(
          "jmp_long",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("rel", SWORD));
    }
  }
}
