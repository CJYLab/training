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
import ru.ispras.microtesk.model.metadata.MetaAddressingMode;
import ru.ispras.microtesk.model.metadata.MetaArgument;
import ru.ispras.microtesk.model.data.Type;

/**
 * The {@code RCOP0} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class RCOP0 extends MetaAddressingMode {
  private static RCOP0 instance = null;

  public static RCOP0 get() {
    if (null == instance) {
      instance = new RCOP0();
    }
    return instance;
  }

  private RCOP0() {
    super(
        "RCOP0",
        WORD,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("i", INDEX));
  }
}
