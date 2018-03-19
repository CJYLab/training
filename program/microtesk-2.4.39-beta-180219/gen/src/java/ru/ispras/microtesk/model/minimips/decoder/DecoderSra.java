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
import ru.ispras.microtesk.model.minimips.op.sra;
import ru.ispras.microtesk.model.minimips.mode.REG;
import ru.ispras.microtesk.model.Immediate;

/**
 * The {@code DecoderSra} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderSra extends DecoderItem {
  private static DecoderSra instance = null;

  public static DecoderSra get() {
    if (null == instance) {
      instance = new DecoderSra();
    }
    return instance;
  }

  private DecoderSra() {
    super(
        32,
        true,
        "00000000000000000000000000000011",
        "11111111111000000000000000111111"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    REG rd = null;
    REG rt = null;
    Immediate sa = null;

    if (!matchNextOpc(image, BitVector.valueOf("00000000000", 2, 11))) {
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

    sa = readNextImmediate(image, Type.CARD(5));

    if (!matchNextOpc(image, BitVector.valueOf("000011", 2, 6))) {
      return null;
    }

    return newResult(new sra(rd, rt, sa));
  }
}
