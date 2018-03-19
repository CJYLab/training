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
import ru.ispras.microtesk.model.x86.op.add_r16i16;
import ru.ispras.microtesk.model.x86.mode.R16;
import ru.ispras.microtesk.model.x86.mode.IMM16;

/**
 * The {@code DecoderAdd_r16i16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderAdd_r16i16 extends DecoderItem {
  private static DecoderAdd_r16i16 instance = null;

  public static DecoderAdd_r16i16 get() {
    if (null == instance) {
      instance = new DecoderAdd_r16i16();
    }
    return instance;
  }

  private DecoderAdd_r16i16() {
    super(
        32,
        true,
        "10000001110000000000000000000000",
        "11111111111110000000000000000000"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    R16 op1 = null;
    IMM16 op2 = null;

    if (!matchNextOpc(image, BitVector.valueOf("1000000111000", 2, 13))) {
      return null;
    }

    op1 = (R16) readNextPrimitive(image, DecoderR16.get());
    if (null == op1) {
      return null;
    }

    op2 = (IMM16) readNextPrimitive(image, DecoderIMM16.get());
    if (null == op2) {
      return null;
    }

    return newResult(new add_r16i16(op1, op2));
  }
}
