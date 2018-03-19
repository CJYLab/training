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

package ru.ispras.microtesk.model.vmem.mmu.sim;

import ru.ispras.fortress.data.types.bitvector.BitVector;
import ru.ispras.microtesk.mmu.model.api.Data;
import ru.ispras.microtesk.mmu.model.api.Address;

/**
 * The {@code VA} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class VA implements Data, Address {
  public final BitVector value;

  public VA() {
    this.value = BitVector.newEmpty(16);
  }

  public VA(final BitVector value) {
    this();
    asBitVector().assign(value);
  }

  public void assign(final VA other) {
    this.value.assign(other.value);
  }

  @Override
  public BitVector asBitVector() {
    return BitVector.newMapping(
        value
        );
  }

  @Override
  public String toString() {
    return String.format(
        "VA [value=0x%s]",
        value.toHexString()
        );
  }

  @Override
  public BitVector getValue() {
    return value;
  }
}
