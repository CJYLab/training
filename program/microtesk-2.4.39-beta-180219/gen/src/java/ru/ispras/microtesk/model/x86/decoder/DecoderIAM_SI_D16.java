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

package ru.ispras.microtesk.model.x86.decoder;

import static ru.ispras.microtesk.model.x86.TypeDefs.*;

import ru.ispras.microtesk.model.decoder.DecoderItem;
import ru.ispras.microtesk.model.decoder.DecoderResult;
import ru.ispras.fortress.data.types.bitvector.BitVector;
import ru.ispras.microtesk.model.data.Type;
import ru.ispras.microtesk.model.x86.mode.IAM_SI_D16;
import ru.ispras.microtesk.model.Immediate;

/**
 * The {@code DecoderIAM_SI_D16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderIAM_SI_D16 extends DecoderItem {
  private static DecoderIAM_SI_D16 instance = null;

  public static DecoderIAM_SI_D16 get() {
    if (null == instance) {
      instance = new DecoderIAM_SI_D16();
    }
    return instance;
  }

  private DecoderIAM_SI_D16() {
    super(
        16,
        true,
        null,
        null
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    Immediate disp = null;


    return newResult(new IAM_SI_D16(disp));
  }
}
