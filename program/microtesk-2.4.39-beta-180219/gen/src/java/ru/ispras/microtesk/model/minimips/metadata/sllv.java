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
 * The {@code sllv} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class sllv extends MetaOperation {
  private static sllv instance = null;

  public static sllv get() {
    if (null == instance) {
      instance = new sllv();
    }
    return instance;
  }

  private sllv() {
    super(
        "sllv",
        "sllv",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("rd", REG.get(), ArgumentMode.OUT));
    addArgument(new MetaArgument("rt", REG.get(), ArgumentMode.IN));
    addArgument(new MetaArgument("rs", REG.get(), ArgumentMode.IN));

    addShortcut("#root", instruction_sllv.get());
  }

  private static final class instruction_sllv extends MetaOperation {
    private static instruction_sllv instance = null;

    public static instruction_sllv get() {
      if (null == instance) {
        instance = new instruction_sllv();
      }
      return instance;
    }

    private instruction_sllv() {
      super(
          "sllv",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("rd", REG.get(), ArgumentMode.OUT));
      addArgument(new MetaArgument("rt", REG.get(), ArgumentMode.IN));
      addArgument(new MetaArgument("rs", REG.get(), ArgumentMode.IN));
    }
  }
}
