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
import ru.ispras.microtesk.model.x86.op.pushA;

/**
 * The {@code DecoderPushA} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderPushA extends DecoderItem {
  private static DecoderPushA instance = null;

  public static DecoderPushA get() {
    if (null == instance) {
      instance = new DecoderPushA();
    }
    return instance;
  }

  private DecoderPushA() {
    super(
        8,
        true,
        "01100000",
        "11111111"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    if (!matchNextOpc(image, BitVector.valueOf("01100000", 2, 8))) {
      return null;
    }

    return newResult(new pushA());
  }
}
