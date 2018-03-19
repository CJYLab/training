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
import ru.ispras.microtesk.model.vliw.op.SW;
import ru.ispras.microtesk.model.vliw.mode.R;
import ru.ispras.microtesk.model.Immediate;

/**
 * The {@code DecoderSW} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderSW extends DecoderItem {
  private static DecoderSW instance = null;

  public static DecoderSW get() {
    if (null == instance) {
      instance = new DecoderSW();
    }
    return instance;
  }

  private DecoderSW() {
    super(
        32,
        true,
        "10101100000000000000000000000000",
        "11111100000000000000000000000000"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    R base = null;
    R rt = null;
    Immediate offset = null;

    if (!matchNextOpc(image, BitVector.valueOf("101011", 2, 6))) {
      return null;
    }

    base = (R) readNextPrimitive(image, DecoderR.get());
    if (null == base) {
      return null;
    }

    rt = (R) readNextPrimitive(image, DecoderR.get());
    if (null == rt) {
      return null;
    }

    offset = readNextImmediate(image, SHORT);

    return newResult(new SW(base, rt, offset));
  }
}
