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

package ru.ispras.microtesk.model.minimips.mmu.sim;

import java.math.BigInteger;
import ru.ispras.fortress.data.types.bitvector.*;
import ru.ispras.microtesk.model.Execution;

/**
 * The {@code writeData} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class writeData {
  public static void call(
    final BitVector block,
    final BitVector offset,
    final BitVector data) {
    if (offset.equals(BitVector.valueOf(0x0, 3))) {
      block.field(31, 0).assign(data);
    } else if (offset.equals(BitVector.valueOf(0x1, 3))) {
      block.field(63, 32).assign(data);
    } else if (offset.equals(BitVector.valueOf(0x2, 3))) {
      block.field(95, 64).assign(data);
    } else if (offset.equals(BitVector.valueOf(0x3, 3))) {
      block.field(127, 96).assign(data);
    } else if (offset.equals(BitVector.valueOf(0x4, 3))) {
      block.field(159, 128).assign(data);
    } else if (offset.equals(BitVector.valueOf(0x5, 3))) {
      block.field(191, 160).assign(data);
    } else if (offset.equals(BitVector.valueOf(0x6, 3))) {
      block.field(223, 192).assign(data);
    } else {
      block.field(255, 224).assign(data);
    }
  }
}
