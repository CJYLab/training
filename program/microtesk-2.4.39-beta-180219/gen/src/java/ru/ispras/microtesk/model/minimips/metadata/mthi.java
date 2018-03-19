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
 * The {@code mthi} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class mthi extends MetaOperation {
  private static mthi instance = null;

  public static mthi get() {
    if (null == instance) {
      instance = new mthi();
    }
    return instance;
  }

  private mthi() {
    super(
        "mthi",
        "mthi",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("rs", REG.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_mthi.get());
  }

  private static final class instruction_mthi extends MetaOperation {
    private static instruction_mthi instance = null;

    public static instruction_mthi get() {
      if (null == instance) {
        instance = new instruction_mthi();
      }
      return instance;
    }

    private instruction_mthi() {
      super(
          "mthi",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("rs", REG.get(), ArgumentMode.IN));
    }
  }
}
