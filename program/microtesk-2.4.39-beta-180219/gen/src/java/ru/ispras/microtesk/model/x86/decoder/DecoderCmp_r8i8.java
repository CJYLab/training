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
import ru.ispras.microtesk.model.x86.op.cmp_r8i8;
import ru.ispras.microtesk.model.x86.mode.R8;
import ru.ispras.microtesk.model.x86.mode.IMM8;

/**
 * The {@code DecoderCmp_r8i8} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderCmp_r8i8 extends DecoderItem {
  private static DecoderCmp_r8i8 instance = null;

  public static DecoderCmp_r8i8 get() {
    if (null == instance) {
      instance = new DecoderCmp_r8i8();
    }
    return instance;
  }

  private DecoderCmp_r8i8() {
    super(
        24,
        true,
        "100000001100000000000000",
        "111111111111100000000000"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    R8 op1 = null;
    IMM8 op2 = null;

    if (!matchNextOpc(image, BitVector.valueOf("1000000011000", 2, 13))) {
      return null;
    }

    op1 = (R8) readNextPrimitive(image, DecoderR8.get());
    if (null == op1) {
      return null;
    }

    op2 = (IMM8) readNextPrimitive(image, DecoderIMM8.get());
    if (null == op2) {
      return null;
    }

    return newResult(new cmp_r8i8(op1, op2));
  }
}
