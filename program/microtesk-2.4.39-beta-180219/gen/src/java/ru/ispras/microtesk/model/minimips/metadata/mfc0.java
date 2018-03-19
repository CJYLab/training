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
 * The {@code mfc0} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class mfc0 extends MetaOperation {
  private static mfc0 instance = null;

  public static mfc0 get() {
    if (null == instance) {
      instance = new mfc0();
    }
    return instance;
  }

  private mfc0() {
    super(
        "mfc0",
        "mfc0",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("rt", REG.get(), ArgumentMode.OUT));
    addArgument(new MetaArgument("cs", RCOP0.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_mfc0.get());
  }

  private static final class instruction_mfc0 extends MetaOperation {
    private static instruction_mfc0 instance = null;

    public static instruction_mfc0 get() {
      if (null == instance) {
        instance = new instruction_mfc0();
      }
      return instance;
    }

    private instruction_mfc0() {
      super(
          "mfc0",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("rt", REG.get(), ArgumentMode.OUT));
      addArgument(new MetaArgument("cs", RCOP0.get(), ArgumentMode.IN));
    }
  }
}
