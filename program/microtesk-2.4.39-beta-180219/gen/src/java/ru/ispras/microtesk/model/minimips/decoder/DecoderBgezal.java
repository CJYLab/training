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
import ru.ispras.microtesk.model.minimips.op.bgezal;
import ru.ispras.microtesk.model.minimips.mode.REG;
import ru.ispras.microtesk.model.IsaPrimitive;

/**
 * The {@code DecoderBgezal} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderBgezal extends DecoderItem {
  private static DecoderBgezal instance = null;

  public static DecoderBgezal get() {
    if (null == instance) {
      instance = new DecoderBgezal();
    }
    return instance;
  }

  private DecoderBgezal() {
    super(
        32,
        true,
        "00000100000100010000000000000000",
        "11111100000111110000000000000000"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    REG rs = null;
    IsaPrimitive offset = null;

    if (!matchNextOpc(image, BitVector.valueOf("000001", 2, 6))) {
      return null;
    }

    rs = (REG) readNextPrimitive(image, DecoderREG.get());
    if (null == rs) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("10001", 2, 5))) {
      return null;
    }

    offset = (IsaPrimitive) readNextPrimitive(image, DecoderBRANCH_OFFSET.get());
    if (null == offset) {
      return null;
    }

    return newResult(new bgezal(rs, offset));
  }
}
