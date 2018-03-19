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

package ru.ispras.microtesk.model.minimips.decoder;

import static ru.ispras.microtesk.model.minimips.TypeDefs.*;

import ru.ispras.microtesk.model.decoder.DecoderItem;
import ru.ispras.microtesk.model.decoder.DecoderResult;
import ru.ispras.fortress.data.types.bitvector.BitVector;
import ru.ispras.microtesk.model.data.Type;
import ru.ispras.microtesk.model.minimips.op.or;
import ru.ispras.microtesk.model.minimips.mode.REG;

/**
 * The {@code DecoderOr} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderOr extends DecoderItem {
  private static DecoderOr instance = null;

  public static DecoderOr get() {
    if (null == instance) {
      instance = new DecoderOr();
    }
    return instance;
  }

  private DecoderOr() {
    super(
        32,
        true,
        "00000000000000000000000000100101",
        "11111100000000000000011111111111"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    REG rd = null;
    REG rs = null;
    REG rt = null;

    if (!matchNextOpc(image, BitVector.valueOf("000000", 2, 6))) {
      return null;
    }

    rs = (REG) readNextPrimitive(image, DecoderREG.get());
    if (null == rs) {
      return null;
    }

    rt = (REG) readNextPrimitive(image, DecoderREG.get());
    if (null == rt) {
      return null;
    }

    rd = (REG) readNextPrimitive(image, DecoderREG.get());
    if (null == rd) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("00000100101", 2, 11))) {
      return null;
    }

    return newResult(new or(rd, rs, rt));
  }
}
