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
import ru.ispras.microtesk.model.metadata.MetaAddressingMode;
import ru.ispras.microtesk.model.metadata.MetaArgument;
import ru.ispras.microtesk.model.data.Type;

/**
 * The {@code IAM_SI_D8} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class IAM_SI_D8 extends MetaAddressingMode {
  private static IAM_SI_D8 instance = null;

  public static IAM_SI_D8 get() {
    if (null == instance) {
      instance = new IAM_SI_D8();
    }
    return instance;
  }

  private IAM_SI_D8() {
    super(
        "IAM_SI_D8",
        addR,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("disp", SBYTE));
  }
}
