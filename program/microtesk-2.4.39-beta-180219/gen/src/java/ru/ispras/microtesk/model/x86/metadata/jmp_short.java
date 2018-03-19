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
 * The {@code jmp_short} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class jmp_short extends MetaOperation {
  private static jmp_short instance = null;

  public static jmp_short get() {
    if (null == instance) {
      instance = new jmp_short();
    }
    return instance;
  }

  private jmp_short() {
    super(
        "jmp_short",
        "jmp_short",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("rel", SBYTE));

    addShortcut("#root", instruction_jmp_short.get());
  }

  private static final class instruction_jmp_short extends MetaOperation {
    private static instruction_jmp_short instance = null;

    public static instruction_jmp_short get() {
      if (null == instance) {
        instance = new instruction_jmp_short();
      }
      return instance;
    }

    private instruction_jmp_short() {
      super(
          "jmp_short",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("rel", SBYTE));
    }
  }
}
