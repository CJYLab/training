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
import ru.ispras.microtesk.model.minimips.op.addi;
import ru.ispras.microtesk.model.minimips.mode.REG;
import ru.ispras.microtesk.model.Immediate;

/**
 * The {@code DecoderAddi} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderAddi extends DecoderItem {
  private static DecoderAddi instance = null;

  public static DecoderAddi get() {
    if (null == instance) {
      instance = new DecoderAddi();
    }
    return instance;
  }

  private DecoderAddi() {
    super(
        32,
        true,
        "00100000000000000000000000000000",
        "11111100000000000000000000000000"
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    REG rt = null;
    REG rs = null;
    Immediate imm = null;

    if (!matchNextOpc(image, BitVector.valueOf("001000", 2, 6))) {
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

    imm = readNextImmediate(image, SHORT);

    return newResult(new addi(rt, rs, imm));
  }
}
