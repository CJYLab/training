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
import ru.ispras.microtesk.model.vmem.op.mh;
import ru.ispras.microtesk.model.vmem.mode.REG;
import ru.ispras.microtesk.model.Immediate;

/**
 * The {@code DecoderMh} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderMh extends DecoderItem {
  private static DecoderMh instance = null;

  public static DecoderMh get() {
    if (null == instance) {
      instance = new DecoderMh();
    }
    return instance;
  }

  private DecoderMh() {
    super(
        16,
        true,
        "0010000000000000",
        "1111000000000000"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    REG rt = null;
    Immediate im = null;

    if (!matchNextOpc(image, BitVector.valueOf("0010", 2, 4))) {
      return null;
    }

    rt = (REG) readNextPrimitive(image, DecoderREG.get());
    if (null == rt) {
      return null;
    }

    im = readNextImmediate(image, BYTE);

    return newResult(new mh(rt, im));
  }
}
