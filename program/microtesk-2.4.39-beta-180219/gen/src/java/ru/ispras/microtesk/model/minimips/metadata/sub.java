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
 * The {@code sub} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class sub extends MetaOperation {
  private static sub instance = null;

  public static sub get() {
    if (null == instance) {
      instance = new sub();
    }
    return instance;
  }

  private sub() {
    super(
        "sub",
        "sub",
        false,
        false,
        false,
        true,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("rd", REG.get(), ArgumentMode.OUT));
    addArgument(new MetaArgument("rs", REG.get(), ArgumentMode.IN));
    addArgument(new MetaArgument("rt", REG.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_sub.get());
  }

  private static final class instruction_sub extends MetaOperation {
    private static instruction_sub instance = null;

    public static instruction_sub get() {
      if (null == instance) {
        instance = new instruction_sub();
      }
      return instance;
    }

    private instruction_sub() {
      super(
          "sub",
          "instruction",
          true,
          true,
          true,
          true,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("rd", REG.get(), ArgumentMode.OUT));
      addArgument(new MetaArgument("rs", REG.get(), ArgumentMode.IN));
      addArgument(new MetaArgument("rt", REG.get(), ArgumentMode.IN));
    }
  }
}
