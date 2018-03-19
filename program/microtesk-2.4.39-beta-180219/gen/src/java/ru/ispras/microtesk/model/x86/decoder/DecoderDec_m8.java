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
import ru.ispras.microtesk.model.x86.op.dec_m8;
import ru.ispras.microtesk.model.x86.mode.RSEG16;
import ru.ispras.microtesk.model.IsaPrimitive;

/**
 * The {@code DecoderDec_m8} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderDec_m8 extends DecoderItem {
  private static DecoderDec_m8 instance = null;

  public static DecoderDec_m8 get() {
    if (null == instance) {
      instance = new DecoderDec_m8();
    }
    return instance;
  }

  private DecoderDec_m8() {
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

    if (!matchNextOpc(image, BitVector.valueOf("001", 2, 3))) {
      return null;
    }

    seg_ovrd = (RSEG16) readNextPrimitive(image, DecoderRSEG16.get());
    if (null == seg_ovrd) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("11011111110", 2, 11))) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("00", 2, 2))) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("001", 2, 3))) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("000", 2, 3))) {
      return null;
    }

    op1 = (IsaPrimitive) readNextPrimitive(image, DecoderMOFFS.get());
    if (null == op1) {
      return null;
    }

    return newResult(new dec_m8(seg_ovrd, op1));
  }
}
