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
import ru.ispras.microtesk.model.x86.op.jb;
import ru.ispras.microtesk.model.Immediate;

/**
 * The {@code DecoderJb} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderJb extends DecoderItem {
  private static DecoderJb instance = null;

  public static DecoderJb get() {
    if (null == instance) {
      instance = new DecoderJb();
    }
    return instance;
  }

  private DecoderJb() {
    super(
        16,
        true,
        "0111001000000000",
        "1111111100000000"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    Immediate rel = null;

    if (!matchNextOpc(image, BitVector.valueOf("01110010", 2, 8))) {
      return null;
    }

    rel = readNextImmediate(image, SBYTE);

    return newResult(new jb(rel));
  }
}
