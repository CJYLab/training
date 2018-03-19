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

package ru.ispras.microtesk.model.vmem.decoder;

import static ru.ispras.microtesk.model.vmem.TypeDefs.*;

import ru.ispras.microtesk.model.decoder.DecoderItem;
import ru.ispras.microtesk.model.decoder.DecoderResult;
import ru.ispras.fortress.data.types.bitvector.BitVector;
import ru.ispras.microtesk.model.data.Type;
import ru.ispras.microtesk.model.vmem.op.st;
import ru.ispras.microtesk.model.vmem.mode.REG;

/**
 * The {@code DecoderSt} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderSt extends DecoderItem {
  private static DecoderSt instance = null;

  public static DecoderSt get() {
    if (null == instance) {
      instance = new DecoderSt();
    }
    return instance;
  }

  private DecoderSt() {
    super(
        16,
        true,
        "1010000000000000",
        "1111111100000000"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    REG rs = null;
    REG addr = null;

    if (!matchNextOpc(image, BitVector.valueOf("10100000", 2, 8))) {
      return null;
    }

    rs = (REG) readNextPrimitive(image, DecoderREG.get());
    if (null == rs) {
      return null;
    }

    addr = (REG) readNextPrimitive(image, DecoderREG.get());
    if (null == addr) {
      return null;
    }

    return newResult(new st(rs, addr));
  }
}
