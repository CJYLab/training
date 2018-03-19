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
import ru.ispras.microtesk.model.x86.op.mov_rsegr16;
import ru.ispras.microtesk.model.x86.mode.RSEG16;
import ru.ispras.microtesk.model.x86.mode.R16;

/**
 * The {@code DecoderMov_rsegr16} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderMov_rsegr16 extends DecoderItem {
  private static DecoderMov_rsegr16 instance = null;

  public static DecoderMov_rsegr16 get() {
    if (null == instance) {
      instance = new DecoderMov_rsegr16();
    }
    return instance;
  }

  private DecoderMov_rsegr16() {
    super(
        17,
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

    RSEG16 dst = null;
    R16 src = null;

    if (!matchNextOpc(image, BitVector.valueOf("10001110110", 2, 11))) {
      return null;
    }

    dst = (RSEG16) readNextPrimitive(image, DecoderRSEG16.get());
    if (null == dst) {
      return null;
    }

    src = (R16) readNextPrimitive(image, DecoderR16.get());
    if (null == src) {
      return null;
    }

    return newResult(new mov_rsegr16(dst, src));
  }
}
