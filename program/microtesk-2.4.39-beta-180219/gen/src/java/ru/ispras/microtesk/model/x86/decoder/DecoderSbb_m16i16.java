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
import ru.ispras.microtesk.model.x86.op.sbb_m16i16;
import ru.ispras.microtesk.model.x86.mode.RSEG16;
import ru.ispras.microtesk.model.IsaPrimitive;
import ru.ispras.microtesk.model.x86.mode.IMM16;

/**
 * The {@code DecoderSbb_m16i16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderSbb_m16i16 extends DecoderItem {
  private static DecoderSbb_m16i16 instance = null;

  public static DecoderSbb_m16i16 get() {
    if (null == instance) {
      instance = new DecoderSbb_m16i16();
    }
    return instance;
  }

  private DecoderSbb_m16i16() {
    super(
        57,
        false,
        null,
        null
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    RSEG16 seg_ovrd = null;
    IsaPrimitive op1 = null;
    IMM16 op2 = null;

    if (!matchNextOpc(image, BitVector.valueOf("001", 2, 3))) {
      return null;
    }

    seg_ovrd = (RSEG16) readNextPrimitive(image, DecoderRSEG16.get());
    if (null == seg_ovrd) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("11010000001", 2, 11))) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("00", 2, 2))) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("000", 2, 3))) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("000", 2, 3))) {
      return null;
    }

    op1 = (IsaPrimitive) readNextPrimitive(image, DecoderMOFFS.get());
    if (null == op1) {
      return null;
    }

    op2 = (IMM16) readNextPrimitive(image, DecoderIMM16.get());
    if (null == op2) {
      return null;
    }

    return newResult(new sbb_m16i16(seg_ovrd, op1, op2));
  }
}
