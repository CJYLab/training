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

package ru.ispras.microtesk.model.minimips.metadata;

import static ru.ispras.microtesk.model.minimips.TypeDefs.*;

import ru.ispras.microtesk.model.ArgumentMode;
import ru.ispras.microtesk.model.metadata.MetaArgument;
import ru.ispras.microtesk.model.metadata.MetaOperation;
import ru.ispras.microtesk.model.data.Type;

/**
 * The {@code mips_break} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class mips_break extends MetaOperation {
  private static mips_break instance = null;

  public static mips_break get() {
    if (null == instance) {
      instance = new mips_break();
    }
    return instance;
  }

  private mips_break() {
    super(
        "mips_break",
        "mips_break",
        false,
        false,
        false,
        true,
        false,
        false,
        0
        );
    addShortcut("#root", instruction_mips_break.get());
  }

  private static final class instruction_mips_break extends MetaOperation {
    private static instruction_mips_break instance = null;

    public static instruction_mips_break get() {
      if (null == instance) {
        instance = new instruction_mips_break();
      }
      return instance;
    }

    private instruction_mips_break() {
      super(
          "mips_break",
          "instruction",
          true,
          true,
          true,
          true,
          false,
          false,
          0
          );
    }
  }
}
