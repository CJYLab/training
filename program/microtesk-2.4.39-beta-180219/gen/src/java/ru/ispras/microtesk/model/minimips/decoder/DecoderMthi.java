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
import ru.ispras.microtesk.model.minimips.op.mthi;
import ru.ispras.microtesk.model.minimips.mode.REG;

/**
 * The {@code DecoderMthi} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderMthi extends DecoderItem {
  private static DecoderMthi instance = null;

  public static DecoderMthi get() {
    if (null == instance) {
      instance = new DecoderMthi();
    }
    return instance;
  }

  private DecoderMthi() {
    super(
        32,
        true,
        "00000000000000000000000000010001",
        "11111111111111110000011111111111"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    REG rs = null;

    if (!matchNextOpc(image, BitVector.valueOf("0000000000000000", 2, 16))) {
      return null;
    }

    rs = (REG) readNextPrimitive(image, DecoderREG.get());
    if (null == rs) {
      return null;
    }

    if (!matchNextOpc(image, BitVector.valueOf("00000010001", 2, 11))) {
      return null;
    }

    return newResult(new mthi(rs));
  }
}
