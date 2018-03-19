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
import ru.ispras.microtesk.model.x86.op.cmp_m16r16;
import ru.ispras.microtesk.model.x86.mode.RSEG16;
import ru.ispras.microtesk.model.IsaPrimitive;
import ru.ispras.microtesk.model.x86.mode.R16;

/**
 * The {@code DecoderCmp_m16r16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderCmp_m16r16 extends DecoderItem {
  private static DecoderCmp_m16r16 instance = null;

  public static DecoderCmp_m16r16 get() {
    if (null == instance) {
      instance = new DecoderCmp_m16r16();
    }
    return instance;
  }

  private DecoderCmp_m16r16() {
    super(
        41,
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
    R16 op2 = null;

    if (!matchNextOpc(image, BitVector.valueOf("001", 2, 3))) {
      return null;
    }

    seg_ovrd = (RSEG16) readNextPrimitive(image, DecoderRSEG16.get());
    if (null == seg_ovrd) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("11000111001", 2, 11))) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("00", 2, 2))) {
      return null;
    }

    op2 = (R16) readNextPrimitive(image, DecoderR16.get());
    if (null == op2) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("000", 2, 3))) {
      return null;
    }

    op1 = (IsaPrimitive) readNextPrimitive(image, DecoderMOFFS.get());
    if (null == op1) {
      return null;
    }

    return newResult(new cmp_m16r16(seg_ovrd, op1, op2));
  }
}
