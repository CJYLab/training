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
 * The {@code lw} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class lw extends MetaOperation {
  private static lw instance = null;

  public static lw get() {
    if (null == instance) {
      instance = new lw();
    }
    return instance;
  }

  private lw() {
    super(
        "lw",
        "lw",
        false,
        false,
        false,
        false,
        true,
        false,
        32
        );
    addArgument(new MetaArgument("rt", REG.get(), ArgumentMode.OUT));
    addArgument(new MetaArgument("offset", SHORT));
    addArgument(new MetaArgument("address", REG.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_lw.get());
  }

  private static final class instruction_lw extends MetaOperation {
    private static instruction_lw instance = null;

    public static instruction_lw get() {
      if (null == instance) {
        instance = new instruction_lw();
      }
      return instance;
    }

    private instruction_lw() {
      super(
          "lw",
          "instruction",
          true,
          true,
          true,
          false,
          true,
          false,
          32
          );
      addArgument(new MetaArgument("rt", REG.get(), ArgumentMode.OUT));
      addArgument(new MetaArgument("offset", SHORT));
      addArgument(new MetaArgument("address", REG.get(), ArgumentMode.IN));
    }
  }
}
