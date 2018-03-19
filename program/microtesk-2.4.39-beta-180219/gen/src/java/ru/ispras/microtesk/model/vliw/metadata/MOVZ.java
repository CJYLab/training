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

package ru.ispras.microtesk.model.vliw.metadata;

import static ru.ispras.microtesk.model.vliw.TypeDefs.*;

import ru.ispras.microtesk.model.ArgumentMode;
import ru.ispras.microtesk.model.metadata.MetaArgument;
import ru.ispras.microtesk.model.metadata.MetaOperation;
import ru.ispras.microtesk.model.data.Type;

/**
 * The {@code MOVZ} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class MOVZ extends MetaOperation {
  private static MOVZ instance = null;

  public static MOVZ get() {
    if (null == instance) {
      instance = new MOVZ();
    }
    return instance;
  }

  private MOVZ() {
    super(
        "MOVZ",
        "MOVZ",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("rd", R.get(), ArgumentMode.OUT));
    addArgument(new MetaArgument("rs", R.get(), ArgumentMode.IN));
    addArgument(new MetaArgument("rt", R.get(), ArgumentMode.IN));
  }
}
