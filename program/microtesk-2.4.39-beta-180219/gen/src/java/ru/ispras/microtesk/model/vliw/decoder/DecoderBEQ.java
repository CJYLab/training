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

package ru.ispras.microtesk.model.vliw.decoder;

import static ru.ispras.microtesk.model.vliw.TypeDefs.*;

import ru.ispras.microtesk.model.decoder.DecoderItem;
import ru.ispras.microtesk.model.decoder.DecoderResult;
import ru.ispras.fortress.data.types.bitvector.BitVector;
import ru.ispras.microtesk.model.data.Type;
import ru.ispras.microtesk.model.vliw.op.BEQ;
import ru.ispras.microtesk.model.vliw.mode.R;
import ru.ispras.microtesk.model.IsaPrimitive;

/**
 * The {@code DecoderBEQ} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderBEQ extends DecoderItem {
  private static DecoderBEQ instance = null;

  public static DecoderBEQ get() {
    if (null == instance) {
      instance = new DecoderBEQ();
    }
    return instance;
  }

  private DecoderBEQ() {
    super(
        32,
        true,
        "00001000000000000000000000000000",
        "11111100000000000000000000000000"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    R rs = null;
    R rt = null;
    IsaPrimitive offset = null;

    if (!matchNextOpc(image, BitVector.valueOf("000010", 2, 6))) {
      return null;
    }

    rs = (R) readNextPrimitive(image, DecoderR.get());
    if (null == rs) {
      return null;
    }

    rt = (R) readNextPrimitive(image, DecoderR.get());
    if (null == rt) {
      return null;
    }

    offset = (IsaPrimitive) readNextPrimitive(image, DecoderBRANCH_OFFSET.get());
    if (null == offset) {
      return null;
    }

    return newResult(new BEQ(rs, rt, offset));
  }
}
