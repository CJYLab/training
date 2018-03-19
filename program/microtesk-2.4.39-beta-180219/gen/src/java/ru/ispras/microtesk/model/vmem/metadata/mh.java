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

package ru.ispras.microtesk.model.vmem.metadata;

import static ru.ispras.microtesk.model.vmem.TypeDefs.*;

import ru.ispras.microtesk.model.ArgumentMode;
import ru.ispras.microtesk.model.metadata.MetaArgument;
import ru.ispras.microtesk.model.metadata.MetaOperation;
import ru.ispras.microtesk.model.data.Type;

/**
 * The {@code mh} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class mh extends MetaOperation {
  private static mh instance = null;

  public static mh get() {
    if (null == instance) {
      instance = new mh();
    }
    return instance;
  }

  private mh() {
    super(
        "mh",
        "mh",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("rt", REG.get(), ArgumentMode.OUT));
    addArgument(new MetaArgument("im", BYTE));

    addShortcut("#root", instruction_mh.get());
  }

  private static final class instruction_mh extends MetaOperation {
    private static instruction_mh instance = null;

    public static instruction_mh get() {
      if (null == instance) {
        instance = new instruction_mh();
      }
      return instance;
    }

    private instruction_mh() {
      super(
          "mh",
          "instruction",
          true,
          false,
          false,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("rt", REG.get(), ArgumentMode.OUT));
      addArgument(new MetaArgument("im", BYTE));
    }
  }
}
