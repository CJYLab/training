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
import ru.ispras.microtesk.model.x86.op.or_r16r16;
import ru.ispras.microtesk.model.x86.mode.R16;

/**
 * The {@code DecoderOr_r16r16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderOr_r16r16 extends DecoderItem {
  private static DecoderOr_r16r16 instance = null;

  public static DecoderOr_r16r16 get() {
    if (null == instance) {
      instance = new DecoderOr_r16r16();
    }
    return instance;
  }

  private DecoderOr_r16r16() {
    super(
        16,
        true,
        "0000101111000000",
        "1111111111000000"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    R16 op1 = null;
    R16 op2 = null;

    if (!matchNextOpc(image, BitVector.valueOf("0000101111", 2, 10))) {
      return null;
    }

    op1 = (R16) readNextPrimitive(image, DecoderR16.get());
    if (null == op1) {
      return null;
    }

    op2 = (R16) readNextPrimitive(image, DecoderR16.get());
    if (null == op2) {
      return null;
    }

    return newResult(new or_r16r16(op1, op2));
  }
}
