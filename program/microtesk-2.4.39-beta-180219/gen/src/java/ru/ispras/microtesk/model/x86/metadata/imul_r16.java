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
 * The {@code imul_r16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class imul_r16 extends MetaOperation {
  private static imul_r16 instance = null;

  public static imul_r16 get() {
    if (null == instance) {
      instance = new imul_r16();
    }
    return instance;
  }

  private imul_r16() {
    super(
        "imul_r16",
        "imul_r16",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("op1", R16.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_imul_r16.get());
  }

  private static final class instruction_imul_r16 extends MetaOperation {
    private static instruction_imul_r16 instance = null;

    public static instruction_imul_r16 get() {
      if (null == instance) {
        instance = new instruction_imul_r16();
      }
      return instance;
    }

    private instruction_imul_r16() {
      super(
          "imul_r16",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("op1", R16.get(), ArgumentMode.IN));
    }
  }
}
