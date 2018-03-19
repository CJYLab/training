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
import ru.ispras.microtesk.model.vmem.mode.REG;
import ru.ispras.microtesk.model.Immediate;

/**
 * The {@code DecoderREG} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderREG extends DecoderItem {
  private static DecoderREG instance = null;

  public static DecoderREG get() {
    if (null == instance) {
      instance = new DecoderREG();
    }
    return instance;
  }

  private DecoderREG() {
    super(
        4,
        true,
        null,
        null
        );
  }

  public DecoderResult decode(final BitVector image) {
    if (!isOpcMatch(image)) {
      return null;
    }

    resetPosition();

    Immediate i = null;

    i = readNextImmediate(image, INDEX);

    return newResult(new REG(i));
  }
}
