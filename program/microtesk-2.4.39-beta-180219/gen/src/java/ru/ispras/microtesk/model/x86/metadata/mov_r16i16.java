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
 * The {@code mov_r16i16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class mov_r16i16 extends MetaOperation {
  private static mov_r16i16 instance = null;

  public static mov_r16i16 get() {
    if (null == instance) {
      instance = new mov_r16i16();
    }
    return instance;
  }

  private mov_r16i16() {
    super(
        "mov_r16i16",
        "mov_r16i16",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("dst", R16.get(), ArgumentMode.OUT));
    addArgument(new MetaArgument("src", IMM16.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_mov_r16i16.get());
  }

  private static final class instruction_mov_r16i16 extends MetaOperation {
    private static instruction_mov_r16i16 instance = null;

    public static instruction_mov_r16i16 get() {
      if (null == instance) {
        instance = new instruction_mov_r16i16();
      }
      return instance;
    }

    private instruction_mov_r16i16() {
      super(
          "mov_r16i16",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("dst", R16.get(), ArgumentMode.OUT));
      addArgument(new MetaArgument("src", IMM16.get(), ArgumentMode.IN));
    }
  }
}
